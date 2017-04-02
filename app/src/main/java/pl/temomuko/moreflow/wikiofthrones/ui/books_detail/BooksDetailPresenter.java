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

    public void loadBookById(String bookId) {
        WikiService.Creator.newWikiService().getBook(bookId).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                book = response.body();
                getMvpView().showBookDetails(book);
                loadCharacters();
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }


    private void addCharacterById(String id, final boolean last) { //tu jest problem
        WikiService.Creator.newWikiService().getCharacterById(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                charactersList.add(response.body()); //wchodzi ale nie dodaje
                if(last) {
                    getMvpView().showCharactersList(charactersList);
                }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
            }
        });
    }

    private void loadCharacters() {
        if(getBook() != null) {
            List<String> linksToCharacters = getBook().getLinksToCharacters();
            int pageSize = 10;
            for (int i = 0; (i < linksToCharacters.size()) && (i < pageSize); i++) {
                String[] elements = linksToCharacters.get(i).split("/");
                String id = elements[elements.length - 1];
                if(i == pageSize - 1) {
                    addCharacterById(id, true);
                } else {
                    addCharacterById(id, false);
                }
            }
        }
    }
}
