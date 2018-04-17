package com.example.arrayadapterjay;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 30-12-2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private ArrayList<Category> categories;
    AdapterCallBack callBack;

    public CategoryAdapter(ArrayList<Category> categories, AdapterCallBack callBack) {
        this.categories = categories;
        this.callBack = callBack;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterlayout, parent, false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Category category=categories.get(position);
        holder.textView.setText(category.getName());

        holder.view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.changefragment(category);
            }
        });



    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = itemView.findViewById(R.id.textView);

        }
    }
}
