package com.example.newsapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
     ImageView main_img;
     TextView text_title,text_descript;
     TextView date;
     CardView cardView;
     Button button,save;
     ImageButton ibutten;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        main_img = itemView.findViewById(R.id.main_img);
        text_title = itemView.findViewById(R.id.text_title);
        text_descript = itemView.findViewById(R.id.text_descript);
        date = itemView.findViewById(R.id.date);
        cardView = itemView.findViewById(R.id.home_container);
        button = itemView.findViewById(R.id.read);
        ibutten = itemView.findViewById(R.id.img_btn);
        save = itemView.findViewById(R.id.save);

    }
}
