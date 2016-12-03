package pl.temomuko.moreflow.wikiofthrones.ui.base;

/**
 * Created by Szymon on 02.12.2016.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
