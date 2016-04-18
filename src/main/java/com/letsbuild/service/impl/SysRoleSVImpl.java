package com.letsbuild.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.SysRole;
import com.letsbuild.dao.mapper.bo.SysRoleCriteria;
import com.letsbuild.dao.mapper.bo.SysUserRole;
import com.letsbuild.dao.mapper.bo.SysUserRoleCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysRoleSV;

@Service
public class SysRoleSVImpl implements ISysRoleSV {

    @Override
    public List<SysRole> querySysRole(Long userId) throws BusinessException {
        SysUserRoleCriteria userRoleCa = new SysUserRoleCriteria();
        userRoleCa.createCriteria().andUserIdEqualTo(userId);
        List<SysUserRole> userRoleList = MapperFactory.getSysUserRoleMapper().selectByExample(userRoleCa);
        if(CollectionUtil.isEmpty(userRoleList)){
            throw new BusinessException(ExceptCodeConstants.NO_ROLE,"用户角色不存在");
        }
        List<Long> roleIds = new ArrayList<Long>();
        for(SysUserRole userRole:userRoleList){
            roleIds.add(userRole.getRoleId());
        }
        SysRoleCriteria roleCa = new SysRoleCriteria();
        roleCa.createCriteria().andIdIn(roleIds);
        return MapperFactory.getSysRoleMapper().selectByExample(roleCa);
    }

}
