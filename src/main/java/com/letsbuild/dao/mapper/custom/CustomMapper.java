package com.letsbuild.dao.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustomMapper {
    /**
     * 执行获取seq函数
     * @param sequenceCode
     * @return
     */
    @Select("SELECT nextval(#{sequenceCode})")
    long getSeqNextval(@Param("sequenceCode") String sequenceCode);
}
