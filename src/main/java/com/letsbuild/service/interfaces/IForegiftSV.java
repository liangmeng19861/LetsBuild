package com.letsbuild.service.interfaces;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.OrdForegift;

/**
 * 押金
 * 
 * @author lilg
 *
 */
public interface IForegiftSV {
    /**
     * 增加押金
     * 
     * @param ordForegift
     * @throws BusinessException
     */
    public void addForegift(OrdForegift ordForegift) throws BusinessException;

    /**
     * 修改押金
     * 
     * @param ordForegift
     * @throws BusinessException
     */
    public void modForegift(OrdForegift ordForegift) throws BusinessException;
    
    /**
     * 查询押金
     * @param id
     * @throws BusinessException
     */
    public OrdForegift queryForegiftById(Long id) throws BusinessException;

}
