package com.letsbuild.business.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.vo.MenuVo;
import com.letsbuild.vo.UserVo;

/**
 * 系统
 * 
 * @author lilg
 *
 */
public interface ISysBusiSV {
    /**
     * 查询用户信息
     * 
     * @param longname
     * @return
     * @throws BusinessException
     */
    public UserVo queryUser(String loginname) throws BusinessException;

    /**
     * 按照用户查询菜单
     * 
     * @param roleId
     * @return
     * @throws BusinessException
     */
    public List<MenuVo> querySysMenuByUser(Long userId) throws BusinessException;

    /**
     * 查询枚举值
     * 
     * @param table
     * @param column
     * @return
     * @throws BusinessException
     */
    public List<SysLabel> querySysLabel(String table, String column) throws BusinessException;

    /**
     * 查询翻译
     * 
     * @param table
     * @param column
     * @param value
     * @return
     * @throws BusinessException
     */
    public SysLabel querySysLabel(String table, String column, String value)
            throws BusinessException;
}
