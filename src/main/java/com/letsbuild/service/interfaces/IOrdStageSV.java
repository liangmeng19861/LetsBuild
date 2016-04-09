package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.OrdStage;

/**
 * 工期预算
 *
 */
public interface IOrdStageSV {
	/**
	 * 添加工期
	 * @param ordStage
	 * @throws BusinessException
	 */
	public void addOrdStage(OrdStage ordStage) throws BusinessException; 
	
	/**
	 * 修改工期及预算
	 * @param ordStage
	 * @throws BusinessException
	 */
	public void modOrdStage(OrdStage ordStage) throws BusinessException;
	
	/**
	 * 根据订单查询工期
	 * @param orderId
	 * @return
	 * @throws BusinessException
	 */
	public List<OrdStage> queryOrdStageByOrderId(Long orderId) throws BusinessException;
}
