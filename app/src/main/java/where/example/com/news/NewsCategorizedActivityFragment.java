package where.example.com.news;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import where.example.com.news.Adapter.CustomAdapter;
import where.example.com.news.Adapter.NewsAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsCategorizedActivityFragment extends Fragment {

    NewsInterface newsInterface;
    NewsAdapter newsAdapter;
    public CustomAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<News.Articles> news = new ArrayList<>();

        public NewsCategorizedActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_news_categorized, container, false);
        int cat = (Integer) getArguments().getInt("k");
        Log.i("category position",String.valueOf(cat));
        //responseText = (TextView) findViewById(R.id.test);
        newsInterface = NewsClient.getClient().create(NewsInterface.class);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.categorized_news_list);
        /**
         GET List Resources
         **/

        if (cat == 0)
        {
            Call<News>call = newsInterface.us_business();
            call.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {

                    Log.d("TAG", response.code() + "");
                    String displayResponse = "";

                    newsAdapter = new NewsAdapter();
                    news = newsAdapter.Response_adapter(response);
                    Log.i("testes", news.get(0).title);
                    // the recycler View
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new CustomAdapter(getActivity(),news);
                    recyclerView.setAdapter(adapter);

                }
                @Override
                public void onFailure(Call<News> call, Throwable t) {
                    call.cancel();
                }
            });

        }
        else if (cat == 1)
        {
            Call<News>call = newsInterface.bitcoins();
            call.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {

                    Log.d("TAG", response.code() + "");
                    String displayResponse = "";

                    newsAdapter = new NewsAdapter();
                    news = newsAdapter.Response_adapter(response);
                    Log.i("testes", news.get(0).title);
                    // the recycler View
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new CustomAdapter(getActivity(),news);
                    recyclerView.setAdapter(adapter);

                }
                @Override
                public void onFailure(Call<News> call, Throwable t) {
                    call.cancel();
                }
            });
        }
        else if (cat == 2)
        {
            Call<News>call = newsInterface.wallstreet_journal();
            call.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {

                    Log.d("TAG", response.code() + "");
                    String displayResponse = "";

                    newsAdapter = new NewsAdapter();
                    news = newsAdapter.Response_adapter(response);
                    Log.i("testes", news.get(0).title);
                    // the recycler View
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new CustomAdapter(getActivity(),news);
                    recyclerView.setAdapter(adapter);

                }
                @Override
                public void onFailure(Call<News> call, Throwable t) {
                    call.cancel();
                }
            });
        }
        else if (cat==3)
        {
            Call<News>call = newsInterface.tech();
            call.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {

                    Log.d("TAG", response.code() + "");
                    String displayResponse = "";

                    newsAdapter = new NewsAdapter();
                    news = newsAdapter.Response_adapter(response);
                    Log.i("testes", news.get(0).title);
                    // the recycler View
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new CustomAdapter(getActivity(),news);
                    recyclerView.setAdapter(adapter);


                }
                @Override
                public void onFailure(Call<News> call, Throwable t) {
                    call.cancel();
                }
            });
        }




                //      responseText.setText(displayResponse);

            return rootview;
    }
}
