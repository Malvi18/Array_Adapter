package com.example.arrayadapterjay;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class BlankFragment extends Fragment implements AdapterCallBack {

    private ArrayList<Category> categories;
    Context context;
    RecyclerView recyclerView;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        context = getActivity();
        Toolbar toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        recyclerView = view.findViewById(R.id.recycleview);
        preparedata();

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        CategoryAdapter adapter = new CategoryAdapter(categories,BlankFragment.this);
        recyclerView.setAdapter(adapter);
        return view;


    }

    private void preparedata() {
        categories = new ArrayList<>();{
            categories.add(new Category(1,"item1"));
            categories.add(new Category(2,"item2"));
            categories.add(new Category(3,"item3"));
            categories.add(new Category(4,"item4"));
            categories.add(new Category(5,"item5"));


        }


    }

    @Override
    public Void changefragment(Category category) {
        Fragment fragment = new BlankFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("NAME",category.getName());
        bundle.putInt("ID",category.getId());
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();


        return null;
    }
}
