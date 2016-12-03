package pl.temomuko.moreflow.wikiofthrones.ui.books;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksActivity extends SuperActivity implements BooksMvpView {

    @BindView(R.id.recycler_view_books)
    RecyclerView recyclerView;

    @BindView(R.id.book_toolbar)
    Toolbar toolbar;

    BooksAdapter booksAdapter;
    BooksPresenter booksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setupToolbar(toolbar, "Books", false);
        setupRecyclerView();

        booksPresenter = new BooksPresenter();
        booksPresenter.attachView(this);
        booksPresenter.prepareBooksList();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }

    }

    private void setupRecyclerView() {
        booksAdapter = new BooksAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(booksAdapter);
    }

    public void showBooksList(List<Book> booksList) {
        booksAdapter.setBooks(booksList);
        booksAdapter.notifyDataSetChanged();
    }

    public void showError() {
        Toast.makeText(this, "connection error", Toast.LENGTH_LONG).show();
    }

    public void showLoadingCircle() {

    }

    public void hideLoadingCircle() {

    }

    public BooksAdapter getBooksAdapter() {
        return booksAdapter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        booksPresenter.detachView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_books;
    }
}
