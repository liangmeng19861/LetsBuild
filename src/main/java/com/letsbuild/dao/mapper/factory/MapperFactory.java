package com.letsbuild.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.letsbuild.dao.mapper.interfaces.UserMapper;


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

    public static UserMapper getUserMapper() {
        return sqlSessionTemplate.getMapper(UserMapper.class);
    }
    

}
