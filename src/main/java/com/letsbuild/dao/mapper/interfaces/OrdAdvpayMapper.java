package com.letsbuild.dao.mapper.interfaces;

import com.letsbuild.dao.mapper.bo.OrdAdvpay;
import com.letsbuild.dao.mapper.bo.OrdAdvpayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdAdvpayMapper {
    int countByExample(OrdAdvpayCriteria example);

    int deleteByExample(OrdAdvpayCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdAdvpay record);

    int insertSelective(OrdAdvpay record);

    List<OrdAdvpay> selectByExample(OrdAdvpayCriteria example);

    OrdAdvpay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdAdvpay record, @Param("example") OrdAdvpayCriteria example);

    int updateByExample(@Param("record") OrdAdvpay record, @Param("example") OrdAdvpayCriteria example);

    int updateByPrimaryKeySelective(OrdAdvpay record);

    int updateByPrimaryKey(OrdAdvpay record);
}