import domain.Currency;
import service.Parser;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Service;
import service.*;

public class ParserRunner {

    public static void main(String[] args){

        // Map operation initialization start here
        Map <Service, Parser> parcerTypes = new HashMap<>();
        parcerTypes.put(Service.DOMXML, new ParcerDomXML());
        parcerTypes.put(Service.SAXXML, new ParcerSaxXML());
        parcerTypes.put(Service.JSON, new ParcerJson());
        parcerTypes.put(Service.HTML, new ParcerHTML());

        Parser parcer = parcerTypes.get(Service.DOMXML);
        System.out.println("*1111111111111111111111111111111111111111111111111111111111*");

        try {
            URL url = new URL("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
            URLConnection connection = url.openConnection();
            connection.getURL();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");

            List<Currency> curs = parcer.parse(connection.getInputStream());

            System.out.println(curs);
            for (Currency value: curs
                 ) {
                if (value.getCode() == 840) {
                    System.out.println(value);
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        parcer = parcerTypes.get(Service.SAXXML);
        System.out.println("*222222222222222222222222222222222222222222222222222222222222*");

        try {
            URL url = new URL("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
            URLConnection connection = url.openConnection();
            connection.getURL();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");

            List<Currency> curs = parcer.parse(connection.getInputStream());

            System.out.println(curs);
            for (Currency value: curs
                    ) {
                if (value.getCode() == 840) {
                    System.out.println(value);
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
