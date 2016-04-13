package com.letsbuild.service.impl;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysMenuSV;

@Service
public class SysMenuSVImpl implements ISysMenuSV {

	@Override
	public SysMenu querySysMenu(Long menuId) throws BusinessException {
		return MapperFactory.getSysMenuMapper().selectByPrimaryKey(menuId);
	}
	
}
