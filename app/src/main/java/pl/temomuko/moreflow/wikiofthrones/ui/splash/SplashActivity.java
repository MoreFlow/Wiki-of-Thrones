package pl.temomuko.moreflow.wikiofthrones.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.common.Constants;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.main.MainActivity;

/**
 * Created by Szymon on 23.10.2016.
 */

public class SplashActivity extends SuperActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, Constants.SPLASH_SCREEN_DURATION);
    }

    private void startMainActivity() {
        MainActivity.startActivity(this);
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
