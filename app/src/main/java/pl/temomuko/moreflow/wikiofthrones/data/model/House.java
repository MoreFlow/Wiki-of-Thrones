package pl.temomuko.moreflow.wikiofthrones.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 02.12.2016.
 */

public class House {

    public String url;
    public String name;
    public String region;
    public String coatOfArms;
    public String words;
    public List<String> titles = new ArrayList<>();
    public List<String> seats = new ArrayList<>();
    public String currentLord;
    public String heir;
    public String overlord;
    public String founded;
    public String founder;
    public String diedOut;
    public List<String> ancestralWeapons = new ArrayList<>();
    public List<String> cadetBranches = new ArrayList<>();
    public List<String> swornMembers = new ArrayList<>();

}