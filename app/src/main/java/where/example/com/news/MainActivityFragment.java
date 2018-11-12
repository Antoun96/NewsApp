package where.example.com.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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


public class MainActivityFragment extends Fragment {

    NewsInterface newsInterface;
    NewsAdapter newsAdapter;
    public CustomAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<News.Articles> news = new ArrayList<>();


    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_main_activity, container, false);


        //responseText = (TextView) findViewById(R.id.test);
        newsInterface = NewsClient.getClient().create(NewsInterface.class);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.news_list);
        /**
         GET List Resources
         **/
        Call<News> call = newsInterface.us_business();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                Log.d("TAG",response.code()+"");
                String displayResponse = "";

                newsAdapter = new NewsAdapter();

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                adapter = new CustomAdapter(getActivity(),newsAdapter.Response_adapter(response));
                recyclerView.setAdapter(adapter);

                //      responseText.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                call.cancel();
            }
        });

        return rootview;
    }

}
