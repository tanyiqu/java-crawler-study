package com.tanyiqu.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class Demo_06_HttpClientPool {

    @Test
    public void test() {
        try {
            PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager();
            doGet(clientConnectionManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void doGet(PoolingHttpClientConnectionManager clientConnectionManager) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(clientConnectionManager).build();

        // 创建HTTPGet对象，设置url
        HttpGet httpGet = new HttpGet("http://www.tanyiqu.top/");

        // 使用HttpClient发送请求
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpGet);

        // 解析响应
        if (response.getStatusLine().getStatusCode() == 200) {
            String content = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(content);
        }

        // 释放资源
        response.close();
    }

}
