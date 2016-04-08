package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.User;

public interface IUserSV {
	public List<User> queryUser() throws BusinessException;
}
