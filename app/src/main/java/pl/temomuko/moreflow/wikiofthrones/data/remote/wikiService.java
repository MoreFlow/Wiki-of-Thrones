package pl.temomuko.moreflow.wikiofthrones.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Szymon on 23.10.2016.
 */

public interface WikiService {

    String ENDPOINT = "http://anapioficeandfire.com/api/";

    @GET("books")
    Call<List<Book>> getBooks();

    @GET("books/{id}")
    Call<Book> getBook(@Path("id") int id);




    class Creator {

        public static WikiService newWikiService() {

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            return retrofit.create(WikiService.class);
        }
    }

}
