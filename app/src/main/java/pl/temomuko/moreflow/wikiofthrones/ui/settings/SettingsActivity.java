package pl.temomuko.moreflow.wikiofthrones.ui.settings;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;

/**
 * Created by Szymon on 03.12.2016.
 */

public class SettingsActivity extends SuperActivity {

    @BindView(R.id.settings_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setupToolbar(toolbar, "Settings", false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }
}
