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

import java.util.ArrayList;

import where.example.com.news.Category;
import where.example.com.news.NewsCategorizedActivity;
import where.example.com.news.R;

public class GridCustomAdapter extends RecyclerView.Adapter<GridCustomAdapter.ViewHolder> {

    private ArrayList<Category> categories;
    private Activity activity;

    public final static String GRID_SER_KEY = "where.example.com.news.ser";
//    private DetailsFragment detailsFragment;
    private FragmentManager man;
    private FragmentTransaction tran;

    public GridCustomAdapter(Activity activity, ArrayList<Category> categories) {
        this.categories = categories;
        this.activity = activity;
    }

    @Override
    public GridCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridCustomAdapter.ViewHolder viewHolder, final int position) {

            viewHolder.title.setText(categories.get(position).name);
            viewHolder.img_android.setImageResource(categories.get(position).image);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    Intent intent = new Intent(activity, NewsCategorizedActivity.class);
                    intent.putExtra(GRID_SER_KEY, position);
                Log.i("adapterClick" , String.valueOf(position));
                    activity.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_android;
        private TextView title;
        public ViewHolder(View view) {
            super(view);

            img_android = (ImageView) view.findViewById(R.id.categoryimageView);
            title = (TextView) view.findViewById(R.id.textViewcategory);
        }
    }

}

