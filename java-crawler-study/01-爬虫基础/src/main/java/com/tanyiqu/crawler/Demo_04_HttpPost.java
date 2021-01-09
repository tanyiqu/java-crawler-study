package com.tanyiqu.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class Demo_04_HttpPost {

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
        HttpPost httpPost = new HttpPost("http://www.tanyiqu.top/");

        // 使用HttpClient发送请求
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpPost);

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
