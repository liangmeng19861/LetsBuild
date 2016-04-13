package com.letsbuild.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.letsbuild.cache.CacheFactory;
import com.letsbuild.dao.mapper.bo.SysMenu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/application.xml" })
public class CacheSericeTest extends TestCase{
    
    @Test
    public void testCache(){
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        List<SysMenu> menu1 = CacheFactory.getMenu(ids);  
        System.out.println(JSON.toJSONString(menu1));
        List<SysMenu> menu2 = CacheFactory.getMenu(ids);  
        System.out.println(JSON.toJSONString(menu2));
        List<SysMenu> menu3 = CacheFactory.getMenu(ids);  
        System.out.println(JSON.toJSONString(menu3));
        List<SysMenu> menu4 = CacheFactory.getMenu(ids);  
        System.out.println(JSON.toJSONString(menu4));
        List<SysMenu> menu5 = CacheFactory.getMenu(ids);  
        System.out.println(JSON.toJSONString(menu5));
        List<SysMenu> menu6 = CacheFactory.getMenu(ids);  
        System.out.println(JSON.toJSONString(menu6));
        Assert.assertEquals(menu1.get(0), menu2.get(0));
        Assert.assertEquals(menu2.get(0), menu3.get(0));
        Assert.assertEquals(menu3.get(0), menu4.get(0));
        Assert.assertEquals(menu4.get(0), menu5.get(0));
        Assert.assertEquals(menu5.get(0), menu6.get(0));
    }
}
