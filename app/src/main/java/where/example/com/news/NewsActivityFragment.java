package where.example.com.news;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsActivityFragment extends Fragment {


    public NewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_news, container, false);

        News.Articles selected_news = (News.Articles) getArguments().getSerializable("k");

        ImageView news_image = (ImageView) rootView.findViewById(R.id.news_image);
        Picasso.with(getActivity()).load(selected_news.urlToImage).into(news_image);
        ImageView calender = (ImageView)rootView.findViewById(R.id.calender_image);
        calender.setImageResource(R.drawable.calender);
        TextView titleTextView= (TextView)rootView.findViewById(R.id.title_txt);
        titleTextView.setText(selected_news.title);
        TextView dateTextView = (TextView) rootView.findViewById(R.id.date_textview);
        dateTextView.setText(selected_news.publishedAt);
        TextView description = (TextView) rootView.findViewById(R.id.description_txt);
        description.setText(selected_news.description);
        return rootView;
    }
}
