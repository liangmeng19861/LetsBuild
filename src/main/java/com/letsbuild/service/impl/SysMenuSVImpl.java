package com.letsbuild.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.dao.mapper.bo.SysMenuCriteria;
import com.letsbuild.dao.mapper.bo.SysRoleMenu;
import com.letsbuild.dao.mapper.bo.SysRoleMenuCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysMenuSV;

@Service
public class SysMenuSVImpl implements ISysMenuSV {

    @Override
    public SysMenu querySysMenu(Long menuId) throws BusinessException {
        return MapperFactory.getSysMenuMapper().selectByPrimaryKey(menuId);
    }

    @Override
    public List<SysMenu> querySysMenuByRole(Long... roleId) throws BusinessException {
        if (CollectionUtil.isEmpty(roleId)) {
            return new ArrayList<SysMenu>();
        }
        SysRoleMenuCriteria rmExample = new SysRoleMenuCriteria();
        rmExample.createCriteria().andRoleIdIn(Arrays.asList(roleId));
        List<SysRoleMenu> roleMenu = MapperFactory.getSysRoleMenuMapper()
                .selectByExample(rmExample);

        if (CollectionUtil.isEmpty(roleMenu)) {
            return new ArrayList<SysMenu>();
        }
        List<Long> menuIds = new ArrayList<Long>();
        for (SysRoleMenu rm : roleMenu) {
            menuIds.add(rm.getMenuId());
        }
        SysMenuCriteria mExample = new SysMenuCriteria();
        mExample.createCriteria().andIdIn(menuIds);
        return MapperFactory.getSysMenuMapper().selectByExample(mExample);
    }

}
