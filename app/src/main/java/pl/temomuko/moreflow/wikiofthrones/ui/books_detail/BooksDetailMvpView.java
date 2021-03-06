package pl.temomuko.moreflow.wikiofthrones.ui.books_detail;

import java.util.List;

import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.data.model.Character;
import pl.temomuko.moreflow.wikiofthrones.ui.base.MvpView;

/**
 * Created by Szymon on 02.12.2016.
 */

public interface BooksDetailMvpView extends MvpView {

    void showBookDetails(Book book);

    void showCharactersList(List<Character> charactersList);

}