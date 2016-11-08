package pl.temomuko.moreflow.wikiofthrones.ui.books;

import java.util.List;

import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.ui.base.MvpView;

/**
 * Created by Szymon on 08.11.2016.
 */

public interface BooksMvpView extends MvpView {

    void showBooksList(List<Book> booksList);

    void showError();

    void showLoadingCircle();

    void hideLoadingCircle();
}
