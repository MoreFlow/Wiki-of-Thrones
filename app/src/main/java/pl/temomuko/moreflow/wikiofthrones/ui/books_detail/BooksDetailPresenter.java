package pl.temomuko.moreflow.wikiofthrones.ui.books_detail;

import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WikiService;
import pl.temomuko.moreflow.wikiofthrones.ui.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Szymon on 02.12.2016.
 */

public class BooksDetailPresenter extends BasePresenter<BooksDetailMvpView> {

    private Book book;

    public Book getBook() {
        return book;
    }


    public void getBookById(String id) {
        WikiService.Creator.newWikiService().getBook(id).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                book = response.body();
                getMvpView().setBook(book);
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }
}
