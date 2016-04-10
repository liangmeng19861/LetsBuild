package com.letsbuild.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class OrderTest  extends TestCase {
    
    private String baseUrl = "http://127.0.0.1:8080/LetsBuild/order";
    
    @Test
    public void testReceive(){
        String url = baseUrl+"/receive";
        Map<String, String> params = new HashMap<String, String>();
        params.put("projectCode", "ORD01");
        params.put("projectLeader", "111");
        params.put("provinceCode", "01");
        params.put("cityCode", "01");
        params.put("brandCode", "01");
        params.put("merchant", "国贸");
        params.put("address", "国贸三层");
        params.put("contactName", "联系人");
        params.put("contactTel", "联系电话");
        params.put("type", "01");
        params.put("remark", "测试接单立项");
        HttpPost.post(url, params);
    }

}
