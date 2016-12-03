package pl.temomuko.moreflow.wikiofthrones.ui.books;

import java.util.ArrayList;
import java.util.List;

import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WikiService;
import pl.temomuko.moreflow.wikiofthrones.ui.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksPresenter extends BasePresenter<BooksMvpView> {

    private List<Book> booksList;

    public void prepareBooksList() {
        booksList = new ArrayList<>();
        WikiService.Creator.newWikiService().getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                booksList = response.body();
                getMvpView().showBooksList(booksList);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                getMvpView().showError();
            }
        });
    }

}
