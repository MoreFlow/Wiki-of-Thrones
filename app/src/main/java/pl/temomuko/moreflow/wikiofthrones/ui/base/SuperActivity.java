package pl.temomuko.moreflow.wikiofthrones.ui.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import pl.temomuko.moreflow.wikiofthrones.R;

public abstract class SuperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected void setupToolbar(Toolbar toolbar, String title, boolean isHome) {
        if(toolbar != null) {
            toolbar.setTitle(title);
            toolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(toolbar);
            if (!isHome) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected abstract int getLayoutId();
}
