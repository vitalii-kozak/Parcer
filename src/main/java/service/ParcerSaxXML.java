package service;

import domain.Currency;

import java.io.InputStream;
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

public class ParcerSaxXML implements Parser {


    @Override
    public List<Currency> parse(InputStream stream) throws Exception {
        return null;
    }
}
