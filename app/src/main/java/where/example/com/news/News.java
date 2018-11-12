package where.example.com.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Antoun on 5/20/2018.
 */

public class News implements Serializable{

    @SerializedName("status")
    public String status;

    @SerializedName("totalResults")
    public Integer totalResults;

    @SerializedName("articles")
    public List<Articles> articles = null;

    public class Articles implements Serializable{

        @SerializedName("source")
        public Source source = null;

        public class Source implements Serializable{
            @SerializedName("name")
            public String name;
        }

        @SerializedName("title")
        public String title;

        @SerializedName("description")
        public String description;

        @SerializedName("url")
        public String url;

        @SerializedName("urlToImage")
        public String urlToImage;

        @SerializedName("publishedAt")
        public String publishedAt;
    }


}
