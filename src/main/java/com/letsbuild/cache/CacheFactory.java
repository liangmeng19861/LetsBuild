package com.letsbuild.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.dao.mapper.bo.SysMenu;

@Component
public class CacheFactory {

    @Autowired
    private CacheService cs;

    private static CacheService cacheService;

    @PostConstruct
    void init() {
        cacheService = cs;
    }

    /**
     * 获取菜单
     * 
     * @param ids
     * @return
     * @throws BusinessException
     */
    public static List<SysMenu> getMenu(List<Long> ids) throws BusinessException {
        List<SysMenu> list = new ArrayList<SysMenu>();
        for (Long id : ids) {
            list.add(cacheService.querySysMenu(id));
        }
        return list;
    }

    /**
     * 获取所有枚举
     * 
     * @param table
     * @param column
     * @return
     */
    public static List<SysLabel> getLabel(String table, String column) {
        return cacheService.querySysLabel(table, column);
    }

    /**
     * 获取单个翻译
     * 
     * @param table
     * @param column
     * @param value
     * @return
     */
    public static String getLabel(String table, String column, String value) {
        SysLabel label = cacheService.querySysLabel(table, column, value);
        return label == null ? value : label.getLabel();
    }

}
