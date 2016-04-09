package com.letsbuild.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.dao.mapper.bo.SysMenuCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysMenuSV;

@Service
public class SysMenuSVImpl implements ISysMenuSV {

	@Override
	public List<SysMenu> querySysMenu(List<Long> menuId) throws BusinessException {
		SysMenuCriteria example = new SysMenuCriteria();
		example.createCriteria().andIdIn(menuId);
		return MapperFactory.getSysMenuMapper().selectByExample(example);
	}
	
}
