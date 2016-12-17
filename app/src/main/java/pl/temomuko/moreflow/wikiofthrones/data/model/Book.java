package pl.temomuko.moreflow.wikiofthrones.data.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public String getReleased() {
        DateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        DateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date startDate;
        String newDateString = "";
        try {
            startDate = oldFormat.parse(released);
            newDateString = newFormat.format(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDateString;
    }
    public List<String> getLinksToCharacters() {
        return characters;
    }
    public String getAuthor() {
        return authors.get(0);
    }

    public String getId() {
        String[] elements = url.split("/");
        return elements[elements.length - 1];
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCountry() {
        return country;
    }
}