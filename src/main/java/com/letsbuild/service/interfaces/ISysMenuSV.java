package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysMenu;

public interface ISysMenuSV {
    /**
     * 查询菜单列表
     * 
     * @return
     * @throws BusinessException
     */
    public SysMenu querySysMenu(Long menuId) throws BusinessException;
    
    /**
     * 通过角色查询菜单
     * @param roleId
     * @return
     * @throws BusinessException
     */
    public List<SysMenu> querySysMenuByRole(Long... roleId) throws BusinessException;
}
