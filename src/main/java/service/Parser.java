package service;

import domain.Currency;

import java.io.InputStream;
import java.util.List;

public interface Parser {
    List <Currency> parse(InputStream stream) throws Exception;
}
