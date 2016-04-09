package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysUser;

public interface ISysUserSV {
	/**
	 * 查询所有用户
	 * @return
	 * @throws BusinessException
	 */
	public List<SysUser> querySysUser() throws BusinessException;
	
	/**
	 * 根据登录名查询用户
	 * @param loginname
	 * @return
	 * @throws BusinessException
	 */
	public SysUser querySysUser(String loginname) throws BusinessException;
	
}
