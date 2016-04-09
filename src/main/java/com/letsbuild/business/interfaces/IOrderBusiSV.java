package com.letsbuild.business.interfaces;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.OrdOrder;
import com.letsbuild.dao.mapper.bo.OrdStage;

/**
 * 订单管理业务服务
 */
public interface IOrderBusiSV {
	/**
	 * 接单立项
	 * @throws BusinessException
	 */
	void receiveOrder(OrdOrder order) throws BusinessException;
	
	/**
	 * 订单报价
	 * @throws BusinessException
	 */
	public void quoteOrder(OrdOrder order) throws BusinessException;
	
	/**
	 * 下单制作
	 * @throws BusinessException
	 */
	public void submitOrder(OrdOrder order,OrdStage... stages) throws BusinessException;
	
	/**
	 * 工单验收
	 * @throws BusinessException
	 */
	public void acceptanceOrder(OrdOrder order) throws BusinessException;

}
