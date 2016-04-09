package com.letsbuild.dao.mapper.interfaces;

import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.dao.mapper.bo.SysLabelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLabelMapper {
    int countByExample(SysLabelCriteria example);

    int deleteByExample(SysLabelCriteria example);

    int insert(SysLabel record);

    int insertSelective(SysLabel record);

    List<SysLabel> selectByExample(SysLabelCriteria example);

    int updateByExampleSelective(@Param("record") SysLabel record, @Param("example") SysLabelCriteria example);

    int updateByExample(@Param("record") SysLabel record, @Param("example") SysLabelCriteria example);
}