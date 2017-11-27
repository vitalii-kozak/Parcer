package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import domain.Currency;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ParserJson implements Parser {

    private Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();

    @Override
    public List<Currency> parse(InputStream stream) throws Exception {

        Reader reader = new InputStreamReader(stream);
        Type collectionType = new TypeToken<List<Currency>>(){}.getType();

        return gson.fromJson(reader, collectionType);

    }
}
