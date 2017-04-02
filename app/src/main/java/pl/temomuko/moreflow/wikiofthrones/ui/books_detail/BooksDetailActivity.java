package pl.temomuko.moreflow.wikiofthrones.ui.books_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.data.model.Character;
import pl.temomuko.moreflow.wikiofthrones.ui.base.SuperActivity;

/**
 * Created by Szymon on 02.12.2016.
 */

public class BooksDetailActivity extends SuperActivity implements BooksDetailMvpView {

    @BindView(R.id.books_detail_toolbar)
    Toolbar toolbar;

    @BindView(R.id.book_detail_title)
    TextView titleTextView;

    @BindView(R.id.book_detail_author)
    TextView authorTextView;

    @BindView(R.id.book_detail_isbn)
    TextView isbnTextView;

    @BindView(R.id.book_detail_pages)
    TextView pagesTextView;

    @BindView(R.id.book_detail_publisher)
    TextView publisherTextView;

    @BindView(R.id.book_detail_country)
    TextView countryTextView;

    @BindView(R.id.book_detail_release_date)
    TextView dateTextView;

//    @BindView(R.id.book_detail_expandable_layout)
//    ExpandableLinearLayout expandableLinearLayout;

    @BindView(R.id.accordian_header)
    RelativeLayout expandableLayoutHeader;

    @BindView(R.id.expand_image_view)
    ImageView expandImageView;

    @BindView(R.id.books_detail_recycler_view)
    RecyclerView recyclerView;

    private BooksDetailPresenter presenter;

    private CharacterListAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPresenter();
        setupRecyclerView();
        consumeIntent();
    }

    private void setupPresenter() {
        presenter = new BooksDetailPresenter();
        presenter.attachView(this);
    }

    public void consumeIntent() {
        Intent intent = getIntent();
        presenter.loadBookById(intent.getStringExtra("id"));
    }

    @Override
    public void showBookDetails(Book book) {
        super.setupToolbar(toolbar, book.getName(), false);

        titleTextView.setText(book.getName());
        authorTextView.setText(book.getAuthor());
        isbnTextView.setText(book.getIsbn());
        pagesTextView.setText(book.getNumberOfPages().toString());
        publisherTextView.setText(book.getPublisher());
        countryTextView.setText(book.getCountry());
        dateTextView.setText(book.getReleased());
    }

    private void setupRecyclerView() {
        characterAdapter = new CharacterListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(characterAdapter);
    }

    @Override
    public void showCharactersList(List<Character> charactersList) {
        Log.d("TAGG", charactersList.toString());
        characterAdapter.setCharacters(charactersList);
    }
//
//    @OnClick(R.id.expand_image_view)
//    public void expandLayout(View view) {
//        if(expandableLinearLayout.isExpanded()) {
//            expandableLinearLayout.toggle();
//            expandImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_expand_more_black_36dp));
//        } else {
//            expandableLinearLayout.toggle();
//            expandImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_expand_less_black_36dp));
//        }
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_books_detail;
    }
}
