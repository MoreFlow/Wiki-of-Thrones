package pl.temomuko.moreflow.wikiofthrones.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.books.BooksActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.characters.CharactersActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.settings.SettingsActivity;

public class MainActivity extends SuperActivity {

    @BindView(R.id.menu_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setupToolbar(toolbar, getString(R.string.app_name), true);
    }

    @OnClick(R.id.menu_books)
    public void startBooksActivity(View view) {
        Intent intent = new Intent(this, BooksActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.menu_characters)
    public void startCharactersActivity(View view) {
        Intent intent = new Intent(this, CharactersActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.menu_settings)
    public void startSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.menu_info)
    public void showInfo(View view) {
        Toast.makeText(this, R.string.info, Toast.LENGTH_LONG).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
