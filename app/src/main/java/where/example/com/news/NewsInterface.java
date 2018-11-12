package where.example.com.news;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Antoun on 5/20/2018.
 */

public interface NewsInterface {

    @GET("top-headlines?country=us&category=business&apiKey=4699376be1de4231acd6bacfeec9e532")
    Call<News> us_business();

    @GET("everything?q=bitcoin&sortBy=publishedAt&apiKey=4699376be1de4231acd6bacfeec9e532")
    Call<News> bitcoins();

    @GET("top-headlines?sources=techcrunch&apiKey=4699376be1de4231acd6bacfeec9e532")
    Call<News> tech();

    @GET("everything?domains=wsj.com&apiKey=4699376be1de4231acd6bacfeec9e532")
    Call<News> wallstreet_journal();
}
