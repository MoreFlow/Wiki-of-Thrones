package pl.temomuko.moreflow.wikiofthrones.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.temomuko.moreflow.wikiofthrones.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void startActivity(final Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}
