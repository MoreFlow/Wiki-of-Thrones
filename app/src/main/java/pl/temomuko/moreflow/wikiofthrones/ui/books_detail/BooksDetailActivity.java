package pl.temomuko.moreflow.wikiofthrones.ui.books_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.ui.SuperActivity;

/**
 * Created by Szymon on 02.12.2016.
 */

public class BooksDetailActivity extends SuperActivity implements BooksDetailMvpView {

    @BindView(R.id.book_id)
    TextView nameTextView;

    @BindView(R.id.books_detail_toolbar)
    Toolbar toolbar;

    private BooksDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPresenter();
        consumeIntent();
    }

    private void setupPresenter() {
        presenter = new BooksDetailPresenter();
        presenter.attachView(this);
    }

    public void consumeIntent() {
        Intent intent = getIntent();
        presenter.getBookById(intent.getStringExtra("id"));
    }

    @Override
    public void setBook(Book book) {
        super.setupToolbar(toolbar, presenter.getBook().getName(), false);
        showBookDetails(book);
    }

    @Override
    public void showBookDetails(Book book) {
        nameTextView.setText(book.getName());
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_books_detail;
    }
}
