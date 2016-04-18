package com.letsbuild.vo;

import java.util.List;

import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.dao.mapper.bo.SysRole;
import com.letsbuild.dao.mapper.bo.SysUser;

public class UserVo extends SysUser {
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

}
