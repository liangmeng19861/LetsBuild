package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysLabel;

public interface ISysLabelSV {
    /**
     * 获取枚举
     * 
     * @param table
     * @param column
     * @return
     * @throws BusinessException
     */
    public List<SysLabel> querySysLabel(String table, String column) throws BusinessException;

    /**
     * 获取翻译
     * 
     * @param table
     * @param column
     * @param value
     * @return
     * @throws BusinessException
     */
    public SysLabel querySysLabel(String table, String column, String value)
            throws BusinessException;
}
