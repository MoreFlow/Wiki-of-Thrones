package pl.temomuko.moreflow.wikiofthrones.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.books.BooksActivity;

public class MainActivity extends SuperActivity implements MainMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.menu_books)
    public void startBooksActivity(View view) {
        Intent intent = new Intent(this, BooksActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
