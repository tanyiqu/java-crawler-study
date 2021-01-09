package com.tanyiqu.crawler;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo_05_HttpPost_param {

    @Test
    public void test() {
        try {
            doCrawl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 不抛异常写法
    public void doCrawl() throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建httpPost对象，设置url
//        HttpPost httpPost = new HttpPost("https://s.taobao.com/search");
        HttpPost httpPost = new HttpPost("http://www.tanyiqu.top/");

        // 声明List集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("t", "111111111"));

        // 创建表单的entity的对象
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");

        // 设置表单的entity对象到post请求中
        httpPost.setEntity(formEntity);

        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");


        // 使用HttpClient发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 解析响应
        if (response.getStatusLine().getStatusCode() == 200) {
            String content = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(content);
        }

        // 释放资源
        response.close();
        httpClient.close();
    }
}
