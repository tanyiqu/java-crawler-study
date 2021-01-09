import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() throws Exception {
        String url = "http://www.zuidazy4.com/?m=vod-detail-id-23634.html";

        Document doc = Jsoup.connect(url).get();

        String div = doc.select("div#play_1 ul li").toString();


        System.out.println(div);

    }

}


