package com.letsbuild.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.business.interfaces.ISysBusiSV;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.vo.MenuVo;

/**
 * Spring 缓存方法返回值
 * 
 * @author lilg
 *
 */
@Component
public class CacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    private ISysBusiSV sysBusiSV;

    @Cacheable(value = "sysMenuCache", key = "#userId")
    public List<MenuVo> querySysMenu(Long userId) throws BusinessException {
        logger.info("菜单缓存中未找到[userId={}],重新查询数据库", userId);
        return sysBusiSV.querySysMenuByUser(userId);
    }

    @Cacheable(value = "sysLabelCache", key = "#table.concat(1).concat(#column)")
    public List<SysLabel> querySysLabel(String table, String column) throws BusinessException {
        logger.info("字段枚举缓存中未找到[key={}1{}],重新查询数据库", table, column);
        return sysBusiSV.querySysLabel(table, column);
    }

    @Cacheable(value = "sysLabelCache", key = "#table.concat(1).concat(#column).cancat(1).cancat(#value)")
    public SysLabel querySysLabel(String table, String column, String value)
            throws BusinessException {
        logger.info("字段枚举缓存中未找到[key={}1{}1{}],重新查询数据库", table, column, value);
        return sysBusiSV.querySysLabel(table, column, value);
    }
}
