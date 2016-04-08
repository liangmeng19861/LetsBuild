package com.letsbuild.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.User;
import com.letsbuild.dao.mapper.bo.UserCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.IUserSV;

@Service
@Transactional
public class UserSVImpl implements IUserSV {

	@Override
	public List<User> queryUser() throws BusinessException {
		UserCriteria example = new UserCriteria();
		return MapperFactory.getUserMapper().selectByExample(example);
	}
	
}
