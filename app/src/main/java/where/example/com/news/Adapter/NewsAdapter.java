package where.example.com.news.Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import where.example.com.news.News;

/**
 * Created by Antoun on 5/22/2018.
 */

public class NewsAdapter {

    public ArrayList <News.Articles> Response_adapter (Response<News> response)
    {
        ArrayList<News.Articles> news_modified = new ArrayList<>();
        News news = response.body();
        List<News.Articles> articles = news.articles;
        for (News.Articles artic : articles) {
            artic.publishedAt = artic.publishedAt.substring(0,10);
            news_modified.add(artic);
        }

        return news_modified;

    }

}
