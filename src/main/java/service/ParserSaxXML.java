package service;

import domain.Currency;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserSaxXML implements Parser {


    @Override
    public List<Currency> parse(InputStream stream) throws Exception {

        List <Currency> result = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();


        class SAXPars extends DefaultHandler{

            Currency newCurrency;
            String thisElement = "";

            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start parse XML...");
            }

            @Override
            public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
                //System.out.println("Start Element :" + qName);
                if (qName.equals("currency")) {
                    newCurrency = new Currency();
                    //result.add(newCurrency);
                }
                thisElement = qName;
            }

            @Override
            public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
                //System.out.println("End Element :" + qName);
                if (qName.equals("currency")) {
                    System.out.println(newCurrency);
                    result.add(newCurrency);
                }

                thisElement = "";
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (thisElement.equals("r030")) {
                    newCurrency.setCode(new Integer(new String(ch, start, length)));
                }
                if (thisElement.equals("txt")) {
                    newCurrency.setTxt(new String(ch, start, length));
                }
                if (thisElement.equals("rate")) {
                    newCurrency.setExchangeRate(new Double(new String(ch, start, length)));
                }
                if (thisElement.equals("cc")) {
                    newCurrency.setCc(new String(ch, start, length));
                }
                if (thisElement.equals("exchangedate")) {
                    try {
                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date exchangeDate = df.parse(new String(ch, start, length));
                        newCurrency.setExchangeDate(exchangeDate);
                    } catch (ParseException e) {
                        newCurrency.setExchangeDate(null);
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void endDocument() {
                System.out.println("Stop parse XML...");
            }
        }

        SAXPars saxp = new SAXPars();
        parser.parse(stream, saxp);

        return result;

    }
}
