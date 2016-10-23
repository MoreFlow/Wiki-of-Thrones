package pl.temomuko.moreflow.wikiofthrones.ui.books;

import java.util.ArrayList;
import java.util.List;

import pl.temomuko.moreflow.wikiofthrones.data.DataManager;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksPresenter {

    private List<Book> booksList;
    private DataManager dataManager;
    private BooksActivity booksActivity;

    public BooksPresenter(DataManager dataManager, BooksActivity booksActivity) {
        this.dataManager = dataManager;
        this.booksActivity = booksActivity;
    }

    public void prepareBooksList() {
        booksList = new ArrayList<>();
        dataManager.getWikiService().getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                booksList = response.body();
                booksActivity.getBooksAdapter().setBooks(booksList);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

}
