package com.letsbuild.service;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.letsbuild.cache.CacheFactory;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.vo.MenuVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/application.xml" })
public class CacheSericeTest extends TestCase{
    
    private static final Logger logger = LogManager.getLogger(CacheSericeTest.class);
    
    @Test
    public void testCache(){
        List<MenuVo> menu1 = CacheFactory.getMenu(1l);  
        logger.info(JSON.toJSONString(menu1));
        List<MenuVo> menu2 = CacheFactory.getMenu(1l);  
        logger.info(JSON.toJSONString(menu2));
        List<MenuVo> menu3 = CacheFactory.getMenu(1l);  
        logger.info(JSON.toJSONString(menu3));
        List<MenuVo> menu4 = CacheFactory.getMenu(1l);  
        logger.info(JSON.toJSONString(menu4));
        List<MenuVo> menu5 = CacheFactory.getMenu(1l);  
        logger.info(JSON.toJSONString(menu5));
        List<MenuVo> menu6 = CacheFactory.getMenu(1l);  
        logger.info(JSON.toJSONString(menu6));
        Assert.assertEquals(menu1.get(0), menu2.get(0));
        Assert.assertEquals(menu2.get(0), menu3.get(0));
        Assert.assertEquals(menu3.get(0), menu4.get(0));
        Assert.assertEquals(menu4.get(0), menu5.get(0));
        Assert.assertEquals(menu5.get(0), menu6.get(0));
    }
    
    @Test
    public void testLabel(){
        List<SysLabel> labelList = CacheFactory.getLabel("ORD_ORDER", "BRAND_CODE");
        logger.info(JSON.toJSONString(labelList));
    }
}
