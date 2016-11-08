package pl.temomuko.moreflow.wikiofthrones.ui.books;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.data.DataManager;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksActivity extends SuperActivity implements BooksMvpView {

    @BindView(R.id.recycler_view_books)
    RecyclerView recyclerView;

    @Inject BooksAdapter booksAdapter;
    @Inject BooksPresenter booksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public void showError() {

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
