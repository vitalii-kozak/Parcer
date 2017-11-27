package service;

import domain.Currency;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ParserHTML implements Parser {

    @Override
    public List<Currency> parse(InputStream stream) throws Exception {

        Document doc = Jsoup.parse(stream, "UTF-8", "");
        Element table = doc.select("table").get(0); //select the first table.
        List <Currency> result = new ArrayList<>();
        String[] monthList = {"января", "февраля","марта","апреля","мая","июня","июля",
                "августа","сентября","октября","ноября","декабря"};

        Elements rows = table.select("tr");
        System.out.println(rows.size());
        for (int i = 1; i < rows.size() - 1; i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");

            //System.out.println(rows.get(i));
            System.out.print(cols.get(0).selectFirst("a").text() + " ");
            String txt = cols.get(0).selectFirst("a").text();
            System.out.print(cols.get(1).ownText() + " ");
            double rate =  new Double(cols.get(1).ownText());
            System.out.println(cols.get(3).selectFirst("small").ownText());
            DateFormat df = new SimpleDateFormat("dd MM yyyy");

            String dateForReplace = cols.get(3).selectFirst("small").ownText();
            for (int j = 0; j < monthList.length; j++) {
                if (dateForReplace.contains(monthList[j])) {
                    //System.out.println(monthList[j]);
                    dateForReplace = dateForReplace.replace(monthList[j], Integer.toString(j));
                }

            }
            //System.out.println(dateForReplace);
            Date exchangeDate  = df.parse(dateForReplace);

            result.add(new Currency(0,txt, rate,"", exchangeDate));
        }

        return result;
    }
}
