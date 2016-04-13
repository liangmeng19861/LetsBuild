package com.letsbuild.service.interfaces;

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
}
