package tanyiqu.crawler;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo_01_Jsoup {

    @Test
    public void jsoupFromUrl() throws IOException {
        // 解析URL
        Document document = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        // 使用标签选择器选择title
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
    }

    @Test
    public void jsoupFromString() throws IOException {
        // 先用工具类读取文件，获取字符串
        String contents = FileUtils.readFileToString(new File("C:\\Users\\Tanyiqu\\Desktop\\source.html"), "utf8");

        // 解析
        Document document = Jsoup.parse(contents);

        // 使用标签选择器选择title
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
    }

    @Test
    public void jsoupFromFile() throws IOException {
        // 创建文件对象
        File file = new File("C:\\Users\\Tanyiqu\\Desktop\\source.html");

        // 解析
        Document document = Jsoup.parse(file, "utf8");

        // 使用标签选择器选择title
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
    }
}




