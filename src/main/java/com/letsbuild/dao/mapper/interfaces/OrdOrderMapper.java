package com.letsbuild.dao.mapper.interfaces;

import com.letsbuild.dao.mapper.bo.OrdOrder;
import com.letsbuild.dao.mapper.bo.OrdOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdOrderMapper {
    int countByExample(OrdOrderCriteria example);

    int deleteByExample(OrdOrderCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdOrder record);

    int insertSelective(OrdOrder record);

    List<OrdOrder> selectByExample(OrdOrderCriteria example);

    OrdOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdOrder record, @Param("example") OrdOrderCriteria example);

    int updateByExample(@Param("record") OrdOrder record, @Param("example") OrdOrderCriteria example);

    int updateByPrimaryKeySelective(OrdOrder record);

    int updateByPrimaryKey(OrdOrder record);
}