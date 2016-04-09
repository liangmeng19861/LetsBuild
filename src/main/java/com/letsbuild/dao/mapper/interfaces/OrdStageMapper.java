package com.letsbuild.dao.mapper.interfaces;

import com.letsbuild.dao.mapper.bo.OrdStage;
import com.letsbuild.dao.mapper.bo.OrdStageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdStageMapper {
    int countByExample(OrdStageCriteria example);

    int deleteByExample(OrdStageCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdStage record);

    int insertSelective(OrdStage record);

    List<OrdStage> selectByExample(OrdStageCriteria example);

    OrdStage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdStage record, @Param("example") OrdStageCriteria example);

    int updateByExample(@Param("record") OrdStage record, @Param("example") OrdStageCriteria example);

    int updateByPrimaryKeySelective(OrdStage record);

    int updateByPrimaryKey(OrdStage record);
}