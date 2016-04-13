package com.letsbuild.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.service.interfaces.ISysLabelSV;
import com.letsbuild.service.interfaces.ISysMenuSV;

/**
 * Spring 缓存方法返回值
 * 
 * @author lilg
 *
 */
@Component
public class CacheService {

    @Autowired
    private ISysMenuSV sysMenuSV;

    @Autowired
    private ISysLabelSV sysLabelSV;

    @Cacheable(value = "sysMenuCache", key = "#menuId")
    public SysMenu querySysMenu(Long menuId) throws BusinessException {
        return sysMenuSV.querySysMenu(menuId);
    }

    @Cacheable(value = "sysLabelCache", key = "#table.concat(.).concat(#column)")
    public List<SysLabel> querySysLabel(String table, String column) throws BusinessException {
        return sysLabelSV.querySysLabel(table, column);
    }

    @Cacheable(value = "sysLabelCache", key = "#table.concat(.).concat(#column).cancat(.).cancat(#value)")
    public SysLabel querySysLabel(String table, String column, String value)
            throws BusinessException {
        return sysLabelSV.querySysLabel(table, column, value);
    }
}
