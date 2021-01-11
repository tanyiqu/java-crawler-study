package tanyiqu.crawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class Demo_02_Jsoup_get_dom {

    @Test
    public void getElementById() throws IOException {
        // 从url获取document
        Document doc = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        Element input = doc.getElementById("input");

        System.out.println(input.attr("placeholder"));
    }

    @Test
    public void getElementByTag() throws IOException {
        // 从url获取document
        Document doc = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        Elements list = doc.getElementsByTag("a");

        for (Element a : list) {
            System.out.println(a.text() + "：" + a.attr("href"));
        }
    }

    @Test
    public void getElementByClass() throws IOException {
        // 从url获取document
        Document doc = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        Elements elements = doc.getElementsByClass("ul2");

        for (Element element : elements) {
            System.out.println(element.text());
        }
    }

    @Test
    public void getElementByAttribute() throws IOException {
        // 从url获取document
        Document doc = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        Elements elements = doc.getElementsByAttribute("type");

        for (Element element : elements) {
            System.out.println(element.attr("type"));
        }
    }

    @Test
    public void getElementByAttributeValue() throws IOException {
        // 从url获取document
        Document doc = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        Elements elements = doc.getElementsByAttributeValue("type", "search");

        for (Element element : elements) {
            System.out.println(element.attr("type"));
        }
    }


}




