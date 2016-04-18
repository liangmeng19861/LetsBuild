package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysRole;

public interface ISysRoleSV {
    /**
     * 根据用户ID查询角色
     * @param userId
     * @return
     * @throws BusinessException
     */
    public List<SysRole> querySysRole(Long userId) throws BusinessException;
}
