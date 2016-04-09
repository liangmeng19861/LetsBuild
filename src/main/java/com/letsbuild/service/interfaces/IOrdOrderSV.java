package com.letsbuild.service.interfaces;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.OrdOrder;

/**
 * 订单
 */
public interface IOrdOrderSV {
	/**
	 * 创建订单
	 * @throws BusinessException
	 */
	public void addOrder(OrdOrder order) throws BusinessException;
	
	/**
	 * 修改订单
	 * @param order
	 * @throws BusinessException
	 */
	public void modOrder(OrdOrder order) throws BusinessException;
}
