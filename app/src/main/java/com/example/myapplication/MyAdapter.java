package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    private List<NewApi.Result> apiList;

    public MyAdapter(List<NewApi.Result> result) {
        this.apiList = result;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view ,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder( MyAdapter.MyViewHolder holder, int position) {
        NewApi.Result api = apiList.get(position);

        holder.onBind(api);
//        holder.title.setText(apiList.getTitle());
//        holder.url.setText(apiList.getUrl());

    }

    @Override
    public int getItemCount() {
        return apiList.size();

    }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView textViewTitle;
            TextView textViewDescription;
            ImageView imageView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                textViewTitle = itemView.findViewById(R.id.textViewTitle);
                textViewDescription = itemView.findViewById(R.id.textViewDescripytion);
                imageView = itemView.findViewById(R.id.image_view);
            }

            public void onBind(NewApi.Result result){
                textViewTitle.setText(result.title);
                textViewDescription.setText(result.description);
                Picasso.get().load(result.multimedia.get(0).imageUrl).into(imageView);

            }
        }
    }

