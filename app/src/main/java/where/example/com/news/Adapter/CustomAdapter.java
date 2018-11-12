package where.example.com.news.Adapter;

/**
 * Created by Antoun on 5/22/2018.
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import where.example.com.news.CircleTransform;
import where.example.com.news.News;
import where.example.com.news.NewsActivity;
import where.example.com.news.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<News.Articles> news;
    private Activity activity;

    public final static String SER_KEY = "where.example.com.news.ser";
//    private DetailsFragment detailsFragment;
    private FragmentManager man;
    private FragmentTransaction tran;

    public CustomAdapter(Activity activity, ArrayList<News.Articles> news_tmp) {
        this.news = news_tmp;
        this.activity = activity;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder viewHolder, final int position) {

            viewHolder.title.setText(news.get(position).title);
            viewHolder.date.setText(news.get(position).publishedAt);
            if (news.get(position).urlToImage !="") {
                Picasso.with(activity).load(news.get(position).urlToImage).transform(new CircleTransform()).into(viewHolder.img_android);
                Log.v("Picasso", "Loaded");
            }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                News.Articles one_news = news.get(position);

                    Intent intent = new Intent(activity, NewsActivity.class);
                    intent.putExtra(SER_KEY, one_news);
                    Log.v("Selected_news", one_news.title);
                    activity.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_android;
        private TextView title , date;
        public ViewHolder(View view) {
            super(view);

            img_android = (ImageView) view.findViewById(R.id.imageView);
            title = (TextView) view.findViewById(R.id.textViewtitle);
            date = (TextView)view.findViewById(R.id.textViewdate);
        }
    }

}

