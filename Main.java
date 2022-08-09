import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main{
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.krylatskoye.ru/content/ratings/2021/09/0928.html").get();
        Element table = doc.select("table").get(1);

        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            String myString = cols.get(1).text();
            byte[] bytes = myString.getBytes(StandardCharsets.UTF_8);
            String value = new String(bytes, StandardCharsets.UTF_8);
            System.out.print(value);
            System.out.println();
        }
    }
}