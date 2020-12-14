package com.tanyiqu.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetTest {

    public static void main(String[] args) throws Exception {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建HTTPGet对象，设置url
        HttpGet httpGet = new HttpGet("http://www.tanyiqu.top/");

        // 使用HTTPClient发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 解析响应
        if (response.getStatusLine().getStatusCode() == 200) {
            String content = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(content.length());
            response.close();
            httpClient.close();
        }
    }
}
