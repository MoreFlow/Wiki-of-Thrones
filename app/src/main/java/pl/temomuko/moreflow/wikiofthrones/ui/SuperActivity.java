package pl.temomuko.moreflow.wikiofthrones.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Szymon on 23.10.2016.
 */

public abstract class SuperActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
