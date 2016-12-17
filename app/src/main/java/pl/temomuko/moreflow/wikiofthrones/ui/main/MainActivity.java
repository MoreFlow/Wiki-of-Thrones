package pl.temomuko.moreflow.wikiofthrones.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.books.BooksActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.characters.CharactersActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.houses.HousesActivity;
import pl.temomuko.moreflow.wikiofthrones.ui.settings.SettingsActivity;

public class MainActivity extends SuperActivity {

    @BindView(R.id.menu_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setupToolbar(toolbar, getString(R.string.app_name), true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_about:
                Toast.makeText(this, R.string.about, Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
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

    @OnClick(R.id.menu_houses)
    public void startHousesActivity(View view) {
        Intent intent = new Intent(this, HousesActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
