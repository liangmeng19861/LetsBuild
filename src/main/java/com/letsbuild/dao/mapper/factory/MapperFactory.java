package com.letsbuild.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.letsbuild.dao.mapper.custom.CustomMapper;
import com.letsbuild.dao.mapper.interfaces.OrdAdvpayMapper;
import com.letsbuild.dao.mapper.interfaces.OrdForegiftMapper;
import com.letsbuild.dao.mapper.interfaces.OrdOrderMapper;
import com.letsbuild.dao.mapper.interfaces.OrdStageMapper;
import com.letsbuild.dao.mapper.interfaces.SysLabelMapper;
import com.letsbuild.dao.mapper.interfaces.SysMenuMapper;
import com.letsbuild.dao.mapper.interfaces.SysRoleMapper;
import com.letsbuild.dao.mapper.interfaces.SysRoleMenuMapper;
import com.letsbuild.dao.mapper.interfaces.SysUserMapper;
import com.letsbuild.dao.mapper.interfaces.SysUserRoleMapper;

@Component
public class MapperFactory {

	@Autowired
	private SqlSessionTemplate st;

	private static SqlSessionTemplate sqlSessionTemplate;

	@PostConstruct
	void init() {
		setSqlSessionTemplate(st);
	}

	public static void setSqlSessionTemplate(SqlSessionTemplate st) {
		MapperFactory.sqlSessionTemplate = st;
	}

	public static OrdAdvpayMapper getOrdAdvpayMapper() {
		return sqlSessionTemplate.getMapper(OrdAdvpayMapper.class);
	}

	public static OrdForegiftMapper getOrdForegiftMapper() {
		return sqlSessionTemplate.getMapper(OrdForegiftMapper.class);
	}

	public static OrdOrderMapper getOrdOrderMapper() {
		return sqlSessionTemplate.getMapper(OrdOrderMapper.class);
	}

	public static OrdStageMapper getOrdStageMapper() {
		return sqlSessionTemplate.getMapper(OrdStageMapper.class);
	}

	public static SysLabelMapper getSysLabelMapper() {
		return sqlSessionTemplate.getMapper(SysLabelMapper.class);
	}

	public static SysMenuMapper getSysMenuMapper() {
		return sqlSessionTemplate.getMapper(SysMenuMapper.class);
	}

	public static SysRoleMapper getSysRoleMapper() {
		return sqlSessionTemplate.getMapper(SysRoleMapper.class);
	}

	public static SysRoleMenuMapper getSysRoleMenuMapper() {
		return sqlSessionTemplate.getMapper(SysRoleMenuMapper.class);
	}

	public static SysUserMapper getSysUserMapper() {
		return sqlSessionTemplate.getMapper(SysUserMapper.class);
	}

	public static SysUserRoleMapper getSysUserRoleMapper() {
		return sqlSessionTemplate.getMapper(SysUserRoleMapper.class);
	}
	
	public static CustomMapper getCustomMapper(){
	    return sqlSessionTemplate.getMapper(CustomMapper.class);
	}

}
