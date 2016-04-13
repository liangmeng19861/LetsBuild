package com.letsbuild.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Date: 2015年10月15日 <br>
 * 
 * @author lilg
 */
public class HttpPost {
    private static final Logger logger = LoggerFactory.getLogger(HttpPost.class);

    /**
     * 方法一:设置RequestHeader编码为utf－8
     * 
     * @param url
     * @param params
     * @return
     * @author lilg
     */
    public static PostMethod post(String url, Map<String, String> params) {

        // 填入各个表单域的值
        List<NameValuePair> data = new ArrayList<NameValuePair>();
        for (Entry<String, String> param : params.entrySet()) {
            data.add(new NameValuePair(param.getKey(), param.getValue()));
        }
        /**
         * 设置RequestHeader编码为utf－8
         */
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=utf-8");
        // 将表单的值放入postMethod中
        postMethod.setRequestBody(data.toArray(new NameValuePair[] {}));

        HttpClient httpClient = new HttpClient();
        // 设置代理
        // httpClient.getHostConfiguration().setProxy("proxy.asiainfo.com", 8080);
        // 执行postMethod
        try {
            httpClient.executeMethod(postMethod);
            logger.info("请求报文：{}", postMethod.getRequestBodyAsString());
            logger.info("返回报文：{}", postMethod.getResponseBodyAsString());
            return postMethod;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
