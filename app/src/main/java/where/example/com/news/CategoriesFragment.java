package where.example.com.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import where.example.com.news.Adapter.GridCustomAdapter;


public class CategoriesFragment extends Fragment {

    public GridCustomAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Category> categories = new ArrayList<>();
    public CategoriesFragment() {
        Category cat = new Category();
        cat.name = "Business";
        cat.image = R.drawable.business;
        categories.add(cat);
        Category cat2 = new Category();
        cat2.name = "BitCoin";
        cat2.image=R.drawable.bitcoin;
        categories.add(cat2);
        Category cat3 = new Category();
        cat3.name = "WallStreet Journal";
        cat3.image = R.drawable.newspaper;
        categories.add(cat3);
        Category cat4 = new Category();
        cat4.name = "Technology";
        cat4.image = R.drawable.tech;
        categories.add(cat4);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_categories, container, false);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.category_grid);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GridCustomAdapter(getActivity(),categories);
        recyclerView.setAdapter(adapter);

        return rootview;
    }
}

