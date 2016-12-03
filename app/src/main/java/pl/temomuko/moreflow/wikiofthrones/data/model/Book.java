package pl.temomuko.moreflow.wikiofthrones.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 23.10.2016.
 */
public class Book {

    public String url = "";
    public String name;
    public String isbn;
    public List<String> authors = new ArrayList<>();
    public Integer numberOfPages;
    public String publisher;
    public String country;
    public String mediaType;
    public String released;
    public List<String> characters = new ArrayList<>();
    public List<String> povCharacters = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getId() {
        String[] elements = url.split("/");
        return elements[elements.length - 1];
    }

}