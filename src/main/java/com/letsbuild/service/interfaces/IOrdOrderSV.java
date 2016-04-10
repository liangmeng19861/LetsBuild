package com.letsbuild.service.interfaces;

import java.sql.Timestamp;
import java.util.List;

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
	
	/**
	 * 查询订单
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public OrdOrder queryOrdOrderById(Long id) throws BusinessException;
	
	/**
	 * 条件查询（模糊搜索）
	 * @param order
	 * @param start
	 * @param end
	 * @param timeType
	 * @return
	 * @throws BusinessException
	 */
	public List<OrdOrder> queryOrdOrder(OrdOrder order,Timestamp start,Timestamp end,String timeType) throws BusinessException;
}
