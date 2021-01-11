package com.tanyiqu.crawler;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class Demo_07_HttpClient_config {

    @Test
    public void test() {
        try {
            doCrawl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doCrawl() throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建HTTPGet对象，设置url
        HttpGet httpGet = new HttpGet("http://www.tanyiqu.top/");

        // 配置请求信息
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000)            // 创建连接的时间
                .setConnectionRequestTimeout(5000)  // 获取连接的时间
                .setSocketTimeout(10 * 1000)        // 数据传输的最长时间
                .build();

        httpGet.setConfig(config);

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
        httpClient.close();
    }


}
