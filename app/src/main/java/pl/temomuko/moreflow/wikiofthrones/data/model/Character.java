package pl.temomuko.moreflow.wikiofthrones.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 02.12.2016.
 */

public class Character {

    public String url;
    public String name;
    public String gender;
    public String culture;
    public String born;
    public String died;
    public List<String> titles = new ArrayList<>();
    public List<String> aliases = new ArrayList<>();
    public String father;
    public String mother;
    public String spouse;
    public List<String> allegiances = new ArrayList<>();
    public List<String> books = new ArrayList<>();
    public List<String> povBooks = new ArrayList<>();
    public List<String> tvSeries = new ArrayList<>();
    public List<String> playedBy = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCulture() {
        return culture;
    }

    public String getBorn() {
        return born;
    }

    public String getDied() {
        return died;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getSpouse() {
        return spouse;
    }

    public List<String> getAllegiances() {
        return allegiances;
    }

    public List<String> getBooks() {
        return books;
    }

    public List<String> getTvSeries() {
        return tvSeries;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

    @Override
    public String toString() {
        return "Character{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", culture='" + culture + '\'' +
                ", born='" + born + '\'' +
                ", died='" + died + '\'' +
                ", titles=" + titles +
                ", aliases=" + aliases +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", spouse='" + spouse + '\'' +
                ", allegiances=" + allegiances +
                ", books=" + books +
                ", povBooks=" + povBooks +
                ", tvSeries=" + tvSeries +
                ", playedBy=" + playedBy +
                '}';
    }
}