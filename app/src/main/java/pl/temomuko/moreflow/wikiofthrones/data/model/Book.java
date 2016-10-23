package pl.temomuko.moreflow.wikiofthrones.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 23.10.2016.
 */

public class Book {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("authors")
    @Expose
    private List<String> authors = new ArrayList<String>();
    @SerializedName("numberOfPages")
    @Expose
    private Integer numberOfPages;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("mediaType")
    @Expose
    private String mediaType;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("characters")
    @Expose
    private List<String> characters = new ArrayList<>();
    @SerializedName("povCharacters")
    @Expose
    private List<String> povCharacters = new ArrayList<>();


    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getAuthors() {
        return authors;
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

    public String getMediaType() {
        return mediaType;
    }

    public String getReleased() {
        return released;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> getPovCharacters() {
        return povCharacters;
    }
}

