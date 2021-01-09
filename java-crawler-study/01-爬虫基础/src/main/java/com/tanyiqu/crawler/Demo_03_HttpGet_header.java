package com.tanyiqu.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

@SuppressWarnings("DuplicatedCode")
public class Demo_03_HttpGet_header {

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

        // 创建HttpGet对象
        HttpGet httpGet = new HttpGet("http://www.tanyiqu.top/");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        httpGet.setHeader("Host", "host");

        System.out.println("HttpGet: " + httpGet);

        // 使用HttpClient发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

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
