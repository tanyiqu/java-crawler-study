package com.tanyiqu.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Demo_02_HttpGet_param {

    @Test
    public void test() {
        try {
            doCrawl();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // 不抛异常写法
    public void doCrawl() throws IOException, URISyntaxException {
        // https://s.taobao.com/search?q=java

        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("https://s.taobao.com/search");
        // 设置参数
        uriBuilder
                .setParameter("q", "java")
                .setParameter("t", "11111111111111111");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

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
