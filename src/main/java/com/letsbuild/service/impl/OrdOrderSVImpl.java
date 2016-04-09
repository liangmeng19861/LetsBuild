package com.letsbuild.service.impl;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdOrder;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.IOrdOrderSV;

@Service
public class OrdOrderSVImpl implements IOrdOrderSV {

	@Override
	public void addOrder(OrdOrder order) throws BusinessException {
		if(order.getId()==null){
			throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR,"添加订单失败,主键为空");
		}
		MapperFactory.getOrdOrderMapper().insert(order);
	}

	@Override
	public void modOrder(OrdOrder order) throws BusinessException {
		if(order.getId()==null){
			throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR,"修改订单失败,主键为空");
		}
		int result = MapperFactory.getOrdOrderMapper().updateByPrimaryKeySelective(order);
		if(result!=1){
			throw new BusinessException(ExceptCodeConstants.NO_DATA, "修改订单失败，订单不存在");
		}
	}

}
