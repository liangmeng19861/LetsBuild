package com.letsbuild.vo;

import java.util.List;

import com.letsbuild.dao.mapper.bo.SysMenu;

public class MenuVo extends SysMenu{
    private String current;
    
    private List<MenuVo> childMenu;

    public List<MenuVo> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<MenuVo> childMenu) {
        this.childMenu = childMenu;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

}
