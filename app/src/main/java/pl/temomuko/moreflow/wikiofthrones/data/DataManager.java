package pl.temomuko.moreflow.wikiofthrones.data;

import pl.temomuko.moreflow.wikiofthrones.data.local.DatabaseHelper;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WookieService;
import pl.temomuko.moreflow.wikiofthrones.data.local.PreferencesHelper;

/**
 * Created by Szymon on 23.10.2016.
 */

public class DataManager {

    private final WookieService wookieService;
    private final DatabaseHelper databaseHelper;
    private final PreferencesHelper preferencesHelper;

    public DataManager(WookieService wookieService, DatabaseHelper databaseHelper, PreferencesHelper preferencesHelper) {
        this.wookieService = wookieService;
        this.databaseHelper = databaseHelper;
        this.preferencesHelper = preferencesHelper;
    }

    public WookieService getWookieService() {
        return wookieService;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return preferencesHelper;
    }
}
