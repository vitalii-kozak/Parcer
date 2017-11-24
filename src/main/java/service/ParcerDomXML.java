package service;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import domain.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParcerDomXML implements Parser {


    @Override
    public List<Currency> parse(InputStream stream) throws Exception {

//        File fXmlFile = new File("d:/exchange.xml");
//        System.out.println("START : " + fXmlFile);

        List <Currency> result = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(stream);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("currency");

        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                //System.out.println("r030 : " + eElement.getAttribute("r030"));
                Integer code = new Integer(eElement.getElementsByTagName("r030").item(0).getTextContent());
                System.out.println("r030 : " + eElement.getElementsByTagName("r030").item(0).getTextContent());

                String txt = eElement.getElementsByTagName("txt").item(0).getTextContent();
                System.out.println("txt : " + eElement.getElementsByTagName("txt").item(0).getTextContent());

                double exchangeRate = new Double(eElement.getElementsByTagName("rate").item(0).getTextContent());
                System.out.println("rate : " + eElement.getElementsByTagName("rate").item(0).getTextContent());

                String cc = eElement.getElementsByTagName("cc").item(0).getTextContent();
                System.out.println("cc : " + eElement.getElementsByTagName("cc").item(0).getTextContent());

                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Date exchangeDate  = df.parse(eElement.getElementsByTagName("exchangedate").item(0).getTextContent());
                System.out.println("exchangedate : " + eElement.getElementsByTagName("exchangedate").item(0).getTextContent());

                Currency newCurrency = new Currency(code, txt, exchangeRate, cc, exchangeDate);
                result.add(newCurrency);
            }
        }
    return result;
    }
}
