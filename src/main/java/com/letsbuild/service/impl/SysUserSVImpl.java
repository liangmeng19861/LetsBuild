package com.letsbuild.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.dao.mapper.bo.SysUser;
import com.letsbuild.dao.mapper.bo.SysUserCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysUserSV;

@Service
public class SysUserSVImpl implements ISysUserSV {

	@Override
	public List<SysUser> querySysUser() throws BusinessException {
		SysUserCriteria example = new SysUserCriteria();
		return MapperFactory.getSysUserMapper().selectByExample(example);
	}

	@Override
	public SysUser querySysUser(String loginname) throws BusinessException {
		SysUserCriteria example = new SysUserCriteria();
		example.createCriteria().andLoginnameEqualTo(loginname);
		List<SysUser> userlist = MapperFactory.getSysUserMapper().selectByExample(example);
		return CollectionUtil.isEmpty(userlist)?null:userlist.get(0);
	}
	
}
