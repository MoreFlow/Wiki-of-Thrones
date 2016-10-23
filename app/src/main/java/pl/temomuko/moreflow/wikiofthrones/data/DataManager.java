package pl.temomuko.moreflow.wikiofthrones.data;

import retrofit2.Retrofit;
import pl.temomuko.moreflow.wikiofthrones.data.local.PreferencesHelper;

/**
 * Created by Szymon on 23.10.2016.
 */

public class DataManager {

    private final Retrofit retrofit;
    private final PreferencesHelper PreferencesHelper;

    public DataManager(Retrofit retrofit, PreferencesHelper preferencesHelper) {
        this.retrofit = retrofit;
        PreferencesHelper = preferencesHelper;
    }
}
