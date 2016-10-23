package pl.temomuko.moreflow.wikiofthrones.data;

import android.content.Context;

import pl.temomuko.moreflow.wikiofthrones.data.local.DatabaseHelper;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WikiService;
import pl.temomuko.moreflow.wikiofthrones.data.local.PreferencesHelper;

/**
 * Created by Szymon on 23.10.2016.
 */

public class DataManager {

    private final WikiService wikiService;
    private final DatabaseHelper databaseHelper;
    private final PreferencesHelper preferencesHelper;

    public DataManager(WikiService wikiService, DatabaseHelper databaseHelper, PreferencesHelper preferencesHelper) {
        this.wikiService = wikiService;
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
    }

    public WikiService getWikiService() {
        return wikiService;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return preferencesHelper;
    }
}
