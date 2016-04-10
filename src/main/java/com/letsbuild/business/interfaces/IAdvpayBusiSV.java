package com.letsbuild.business.interfaces;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.vo.AdvpayVo;
/**
 * 垫付管理业务服务
 * @author lilg
 *
 */
public interface IAdvpayBusiSV {

    /**
     * 垫付申请
     * 
     * @param vo
     * @throws BusinessException
     */
    public void applyAdvpay(AdvpayVo vo) throws BusinessException;

    /**
     * 垫付付款
     * 
     * @param vo
     * @throws BusinessException
     */
    public void payAdvpay(AdvpayVo vo) throws BusinessException;

    /**
     * 垫付退还
     * 
     * @param vo
     * @throws BusinessException
     */
    public void refundAdvpay(AdvpayVo vo) throws BusinessException;

}
