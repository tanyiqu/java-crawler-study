package com.tanyiqu.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CrawlerFirst {
    static String url = "http://www.tanyiqu.top/";

    public static void main(String[] args) throws Exception {
        // 创建CloseableHttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建get请求
        HttpGet httpGet = new HttpGet(url);

        // 发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 获取响应
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf-8");
            System.out.println(content);
        } else {
            System.out.println("请求失败");
        }


    }
}
