package com.letsbuild.service.interfaces;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.OrdAdvpay;

/**
 * 垫付
 * 
 * @author lilg
 *
 */
public interface IAdvpaySV {
    /**
     * 增加垫付
     * 
     * @param ordAdvpay
     * @throws BusinessException
     */
    public void addAdvpay(OrdAdvpay ordAdvpay) throws BusinessException;

    /**
     * 修改垫付
     * 
     * @param ordAdvpay
     * @throws BusinessException
     */
    public void modAdvpay(OrdAdvpay ordAdvpay) throws BusinessException;

    /**
     * 查询垫付
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    public OrdAdvpay queryAdvpayById(Long id) throws BusinessException;

}
