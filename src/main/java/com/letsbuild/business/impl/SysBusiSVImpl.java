package com.letsbuild.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.BeanUtil;
import com.letsbuild.business.interfaces.ISysBusiSV;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.dao.mapper.bo.SysRole;
import com.letsbuild.dao.mapper.bo.SysUser;
import com.letsbuild.service.interfaces.ISysLabelSV;
import com.letsbuild.service.interfaces.ISysMenuSV;
import com.letsbuild.service.interfaces.ISysRoleSV;
import com.letsbuild.service.interfaces.ISysUserSV;
import com.letsbuild.vo.MenuVo;
import com.letsbuild.vo.UserVo;

@Service
@Transactional
public class SysBusiSVImpl implements ISysBusiSV {

    @Autowired
    private ISysUserSV userSV;

    @Autowired
    private ISysRoleSV roleSV;

    @Autowired
    private ISysMenuSV menuSV;

    @Autowired
    private ISysLabelSV sysLabelSV;

    @Override
    public UserVo queryUser(String loginname) throws BusinessException {
        SysUser sysUser = userSV.querySysUser(loginname);
        if (sysUser == null) {
            return null;
        }
        UserVo vo = new UserVo();
        BeanUtil.copyProperties(sysUser, vo);
        List<SysRole> roleList = roleSV.querySysRole(sysUser.getId());
        vo.setRoles(roleList);
        return vo;
    }

    @Override
    public List<MenuVo> querySysMenuByUser(Long userId) throws BusinessException {
        List<SysRole> roleList = roleSV.querySysRole(userId);
        Map<Long, MenuVo> menuMap = new HashMap<Long, MenuVo>();
        for (SysRole role : roleList) {
            List<SysMenu> sysMenuList = menuSV.querySysMenuByRole(role.getId());
            for (SysMenu sysMenu : sysMenuList) {
                MenuVo vo = new MenuVo();
                BeanUtil.copyProperties(sysMenu, vo);
                menuMap.put(vo.getId(), vo);
            }
        }
        Iterator<Entry<Long, MenuVo>> it = menuMap.entrySet().iterator();
        while(it.hasNext()){
            MenuVo menuVo=it.next().getValue();
            if (menuVo.getPmenu() != -1 && menuMap.containsKey(menuVo.getPmenu())) {
                MenuVo pmenu = menuMap.get(menuVo.getPmenu());
                if (pmenu.getChildMenu() == null) {
                    pmenu.setChildMenu(new ArrayList<MenuVo>());
                }
                pmenu.getChildMenu().add(menuVo);
                it.remove();
            }
        
        }
        List<MenuVo> menuList = new ArrayList<MenuVo>();
        for (MenuVo vo : menuMap.values()) {
            menuList.add(vo);
        }
        return menuList;
    }

    @Override
    public List<SysLabel> querySysLabel(String table, String column) throws BusinessException {
        return sysLabelSV.querySysLabel(table, column);
    }

    @Override
    public SysLabel querySysLabel(String table, String column, String value)
            throws BusinessException {
        return sysLabelSV.querySysLabel(table, column, value);
    }

}
