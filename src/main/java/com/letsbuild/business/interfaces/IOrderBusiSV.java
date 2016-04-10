package com.letsbuild.business.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.vo.OrderVo;

/**
 * 订单管理业务服务
 */
public interface IOrderBusiSV {
    /**
     * 接单立项
     * 
     * @throws BusinessException
     */
    void receiveOrder(OrderVo order) throws BusinessException;

    /**
     * 订单报价
     * 
     * @throws BusinessException
     */
    public void quoteOrder(OrderVo order) throws BusinessException;

    /**
     * 下单制作
     * 
     * @throws BusinessException
     */
    public void submitOrder(OrderVo order) throws BusinessException;

    /**
     * 工单验收
     * 
     * @throws BusinessException
     */
    public void acceptanceOrder(OrderVo order) throws BusinessException;

    /**
     * 开具发票
     * 
     * @throws BusinessException
     */
    public void invoiceOrder(OrderVo order) throws BusinessException;
    
    /**
     * 订单回款
     * @throws BusinessException
     */
    public void incomeOrder(OrderVo order) throws BusinessException;

    /**
     * 修改订单 (修改发票和回款信息)
     * @param order
     * @throws BusinessException
     */
    public void modifyOrder(OrderVo order) throws BusinessException;

    /**
     * 订单查询：主键查询订单详细(翻译，工期)
     * 
     * @throws BusinessException
     */
    public OrderVo queryOrder(Long id) throws BusinessException;

    /**
     * 订单查询：条件查询订单列表(翻译)
     * 
     * @throws BusinessException
     */
    public List<OrderVo> queryOrder(Long projectLeader, String brandCode, String projectCode,
            String provinceCode, String cityCode, String merchant, Timestamp start, Timestamp end,
            String timeType) throws BusinessException;

}
