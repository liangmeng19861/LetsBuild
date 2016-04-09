package com.letsbuild.dao.mapper.interfaces;

import com.letsbuild.dao.mapper.bo.OrdForegift;
import com.letsbuild.dao.mapper.bo.OrdForegiftCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdForegiftMapper {
    int countByExample(OrdForegiftCriteria example);

    int deleteByExample(OrdForegiftCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdForegift record);

    int insertSelective(OrdForegift record);

    List<OrdForegift> selectByExample(OrdForegiftCriteria example);

    OrdForegift selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdForegift record, @Param("example") OrdForegiftCriteria example);

    int updateByExample(@Param("record") OrdForegift record, @Param("example") OrdForegiftCriteria example);

    int updateByPrimaryKeySelective(OrdForegift record);

    int updateByPrimaryKey(OrdForegift record);
}