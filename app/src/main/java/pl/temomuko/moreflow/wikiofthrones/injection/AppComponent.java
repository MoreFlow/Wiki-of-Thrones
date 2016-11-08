package pl.temomuko.moreflow.wikiofthrones.injection;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;
import pl.temomuko.moreflow.wikiofthrones.data.DataManager;

/**
 * Created by Szymon on 08.11.2016.
 */

@Singleton
@Component(modules = {DataManager.class})
public interface AppComponent {
    void inject(Activity activity);

}
