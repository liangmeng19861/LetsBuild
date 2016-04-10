package com.letsbuild.business.interfaces;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.vo.ForegiftVo;

/**
 * 押金管理业务服务
 * 
 * @author lilg
 *
 */
public interface IForegiftBusiSV {
    /**
     * 押金申请
     * 
     * @param vo
     * @throws BusinessException
     */
    public void applyForegift(ForegiftVo vo) throws BusinessException;

    /**
     * 押金付款
     * 
     * @param vo
     * @throws BusinessException
     */
    public void payForegift(ForegiftVo vo) throws BusinessException;

    /**
     * 押金退还
     * 
     * @param vo
     * @throws BusinessException
     */
    public void refundForegift(ForegiftVo vo) throws BusinessException;
}
