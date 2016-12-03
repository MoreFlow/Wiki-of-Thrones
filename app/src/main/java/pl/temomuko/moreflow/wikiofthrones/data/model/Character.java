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

}