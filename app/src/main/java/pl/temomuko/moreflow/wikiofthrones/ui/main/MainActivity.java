package pl.temomuko.moreflow.wikiofthrones.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.OnClick;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.books.BooksActivity;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public static void startActivity(final Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    @OnClick(R.id.menu_books)
    public void startBooksActivity(View view) {
        Log.d("GGGG", "GGGG");
        Intent intent = new Intent(this, BooksActivity.class);
        startActivity(intent);
    }
}
