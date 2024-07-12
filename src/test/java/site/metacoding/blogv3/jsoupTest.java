package site.metacoding.blogv3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class jsoupTest {

    @Test
    public void parse_test1() {
        String html = "<title>First parse</title>"
                + "<p>Parsed HTML into a doc.</p>";
        Document doc = Jsoup.parse(html);
        String text = doc.text();
        System.out.println("text = " + text);

    }

    @Test
    public void parse_test2() {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println("body = " + body);

    }


    @Test
    public void parse_test3() throws IOException {
        Document doc = Jsoup.connect("http://example.com/").get();
        String title = doc.title();
        System.out.println("title = " + title);
    }

    @Test
    public void parse_test() throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        System.out.println("title 이다" + doc.title());

        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            String v1 = headline.attr("title");
            String v2 = headline.absUrl("href");
            System.out.println("title = " + v1);
            System.out.println("href = " + v2);
        }
    }
    
    @Test
    public void parse_test4() throws IOException {
        Document doc = Jsoup.connect("http://example.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
        System.out.println("doc = " + doc);
    }
    
    
    
    
    
    
    
    

    @Test
    public void parse2_test() throws IOException {

        String html = """
                <h1>HelloWorld</h1>
                <h2 id='good'>Bye</h2>
                <img src='fdasf'>
                """;

        Document doc = Jsoup.parse(html);
        //System.out.println(doc);

        Elements els = doc.select("h1");
        //System.out.println(els.get(0).text());

        Element el = doc.selectFirst("#good");
        //System.out.println(el.text());

        Elements els2 = doc.select("img");
        els2.get(0).attr("width", "200px");

        System.out.println(els2);
    }

}
