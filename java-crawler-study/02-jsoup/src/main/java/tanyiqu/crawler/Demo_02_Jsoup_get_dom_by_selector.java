package tanyiqu.crawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class Demo_02_Jsoup_get_dom_by_selector {

    @Test
    public void getElementBySelector() throws IOException {
        // 从url获取document
        Document doc = Jsoup.parse(new URL("http://www.tanyiqu.top/"), 5000);

        Element element1 = doc.select(".ul2").first();
        System.out.println(element1.text());
        System.out.println("===================");

        Element element2 = doc.select("input").first();
        System.out.println(element2.attr("placeholder"));
        System.out.println("===================");

        Elements elements = doc.select(".line a span");
        for (Element element : elements) {
            System.out.println(element.text());
        }

    }


}




