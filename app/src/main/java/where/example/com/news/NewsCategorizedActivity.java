package where.example.com.news;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import where.example.com.news.Adapter.GridCustomAdapter;

public class NewsCategorizedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_categorized);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NewsCategorizedActivityFragment frag ;
        int category = (Integer) getIntent().getSerializableExtra(GridCustomAdapter.GRID_SER_KEY);
        Log.i("ActivityPosition" , String.valueOf(category));

        if (savedInstanceState == null) {
            Bundle bund = new Bundle();
            bund.putInt("k", category);
            frag = new NewsCategorizedActivityFragment();
            frag.setArguments(bund);
            FragmentManager man = getFragmentManager();
            FragmentTransaction tran = man.beginTransaction();
            tran.add(R.id.container, frag);
            tran.commit();
        }
        else
        {
            Bundle bund = new Bundle();
            bund.putInt("k", category);
            frag = new NewsCategorizedActivityFragment();
            frag.setArguments(bund);
            FragmentManager man = getFragmentManager();
            FragmentTransaction tran = man.beginTransaction();
            tran.replace(R.id.container, frag);
            tran.commit();
        }
    }

}
