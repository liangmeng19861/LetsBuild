package com.letsbuild.dao.mapper.interfaces;

import com.letsbuild.dao.mapper.bo.SysRoleMenu;
import com.letsbuild.dao.mapper.bo.SysRoleMenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper {
    int countByExample(SysRoleMenuCriteria example);

    int deleteByExample(SysRoleMenuCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    List<SysRoleMenu> selectByExample(SysRoleMenuCriteria example);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuCriteria example);

    int updateByExample(@Param("record") SysRoleMenu record, @Param("example") SysRoleMenuCriteria example);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}