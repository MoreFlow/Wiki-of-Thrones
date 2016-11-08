package pl.temomuko.moreflow.wikiofthrones.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import pl.temomuko.moreflow.wikiofthrones.data.DataManager;
import pl.temomuko.moreflow.wikiofthrones.data.local.DatabaseHelper;
import pl.temomuko.moreflow.wikiofthrones.data.local.PreferencesHelper;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WikiService;

/**
 * Created by Szymon on 23.10.2016.
 */

public abstract class SuperActivity extends Activity {

    @Inject DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        dataManager = new DataManager(WikiService.Creator.newWikiService(), new DatabaseHelper(), new PreferencesHelper(this));
    }

    protected abstract int getLayoutId();
}
