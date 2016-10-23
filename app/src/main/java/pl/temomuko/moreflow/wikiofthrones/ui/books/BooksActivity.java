package pl.temomuko.moreflow.wikiofthrones.ui.books;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.data.DataManager;
import pl.temomuko.moreflow.wikiofthrones.data.local.DatabaseHelper;
import pl.temomuko.moreflow.wikiofthrones.data.local.PreferencesHelper;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WikiService;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksActivity extends SuperActivity {

    private BooksPresenter booksPresenter;
    private BooksAdapter booksAdapter;

    @BindView(R.id.recycler_view_books)
    RecyclerView recyclerView;

    public BooksActivity() {
        booksAdapter = new BooksAdapter();
        booksPresenter = new BooksPresenter(
                new DataManager(
                        WikiService.Creator.newWikiService(),
                        new DatabaseHelper(),
                        new PreferencesHelper(this)),
                this);
        booksPresenter.prepareBooksList();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(booksAdapter);
    }

    public void showBooksList(List<Book> booksList) {
        booksAdapter.setBooks(booksList);
        booksAdapter.notifyDataSetChanged();
    }

    public BooksAdapter getBooksAdapter() {
        return booksAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_books;
    }
}
