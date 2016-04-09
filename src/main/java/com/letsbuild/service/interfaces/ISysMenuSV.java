package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysMenu;

public interface ISysMenuSV {
	/**
	 * 查询所有菜单
	 * @return
	 * @throws BusinessException
	 */
	public List<SysMenu> querySysMenu(List<Long> menuId) throws BusinessException;
}
