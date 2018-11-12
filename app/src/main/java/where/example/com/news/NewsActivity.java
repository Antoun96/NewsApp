package where.example.com.news;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import where.example.com.news.Adapter.CustomAdapter;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NewsActivityFragment frag ;
        News.Articles lvl_name = (News.Articles) getIntent().getSerializableExtra(CustomAdapter.SER_KEY);

        if (savedInstanceState == null) {
            Bundle bund = new Bundle();
            bund.putSerializable("k", lvl_name);
            frag = new NewsActivityFragment();
            frag.setArguments(bund);
            FragmentManager man = getFragmentManager();
            FragmentTransaction tran = man.beginTransaction();
            tran.add(R.id.containerr, frag);
            tran.commit();
        }
        else
        {
            Bundle bund = new Bundle();
            bund.putSerializable("k", lvl_name);
            frag = new NewsActivityFragment();
            frag.setArguments(bund);
            FragmentManager man = getFragmentManager();
            FragmentTransaction tran = man.beginTransaction();
            tran.replace(R.id.containerr, frag);
            tran.commit();
        }
    }

}
