package pl.temomuko.moreflow.wikiofthrones.ui.books_detail;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.data.model.Character;
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

    private List<Character> charactersList = new ArrayList<>();

    public Book getBook() {
        return book;
    }

    public void getBookById(String bookId) {
        WikiService.Creator.newWikiService().getBook(bookId).clone().enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                book = response.body();
                getMvpView().showBookDetails(book);
                getCharacters();
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }


    public void getCharacterById(String id) { //tu jest problem
        WikiService.Creator.newWikiService().getCharacterById(id).clone().enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                charactersList.add(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Log.d("TAGG", "FAIL!");
            }
        });
    }

    public void getCharacters() {
        if(getBook() != null) {
            for (String characterLink : getBook().getLinksToCharacters()) {
                String[] elements = characterLink.split("/");
                String id = elements[elements.length - 1];
                getCharacterById(id);
            }
            getMvpView().showCharactersList(charactersList);
        }
    }
}
