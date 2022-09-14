package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.BreakingNews;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private clickListener listener;
    int position;
    private List<BreakingNews> breakingNews;

    public CustomAdapter(Context context, List<BreakingNews> breakingNews,clickListener listener) {
        this.context = context;
        this.breakingNews = breakingNews;
        this.listener = listener;
    }




    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.breakingnews_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.position = position;
         if(breakingNews.get(position).getUrlToImage()!=null)
         {
             Picasso.get().load(breakingNews.get(position).getUrlToImage()).into(holder.main_img);
         }
          holder.text_title.setText(breakingNews.get(position).getTitle());
          holder.text_descript.setText(breakingNews.get(position).getDescription());
          holder.date.setText(breakingNews.get(position).getPublishedAt().substring(0,10));

          holder.button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listener.onclicked(breakingNews.get(position));
              }
          });
          holder.save.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listener.onclicked1(breakingNews.get(position));
              }
          });
    }


    @Override
    public int getItemCount() {
        return breakingNews.size();
    }
}
