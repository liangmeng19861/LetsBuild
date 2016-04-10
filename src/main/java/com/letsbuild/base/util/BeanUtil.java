package com.letsbuild.base.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.constants.ExceptCodeConstants;

public class BeanUtil extends BeanUtils {
	
	public static void copySelectProperties(Object source, Object target,Prop... properties) {

		Assert.notNull(source, "源对象不能为null");
		Assert.notNull(target, "目标对象不能为null");
		Assert.isTrue(!CollectionUtil.isEmpty(properties),"复制属性不可为空");
		
		Class<?> actualEditable = target.getClass();

		for(Prop prop:properties){
		    PropertyDescriptor targetPd = getPropertyDescriptor(actualEditable,prop.name);
		    if(targetPd==null){
		        throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR,"对象属性["+prop.name+"]不存在");
		    }
			Method writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null && prop != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), prop.name);
				if (sourcePd != null) {
					Method readMethod = sourcePd.getReadMethod();
					if (readMethod != null &&
							ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
						try {
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							if(value == null && prop.require){
								throw new BusinessException(ExceptCodeConstants.NO_PARAM,"必须属性["+prop.name+"]不能为空");
							}
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
						catch(BusinessException e){
							throw e;
						}
						catch (Throwable ex) {
							throw new FatalBeanException(
									"Could not copy property '" + prop.name + "' from source to target", ex);
						}
					}
				}
			}
		}
	
	}
	
	public static class Prop {
		public Prop(String name, boolean require) {
			this.name = name;
			this.require = require;
		}

		public Prop(String name) {
			this.name = name;
			this.require = true;
		}

		private String name;
		private boolean require;

	}
}
