package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.Models.BreakingNews;
import com.squareup.picasso.Picasso;

public class saved_layout extends AppCompatActivity{
    BreakingNews breakingNews;
    ImageView saved_img;
    TextView saved_title,saved_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_layout);

        saved_img = findViewById(R.id.saved_image);
        saved_title = findViewById(R.id.saved_title);
        saved_date = findViewById(R.id.saved_date);

        breakingNews = (BreakingNews) getIntent().getSerializableExtra("data");

        Picasso.get().load(breakingNews.getUrlToImage()).into(saved_img);
        saved_title.setText(breakingNews.getTitle());
        saved_date.setText(breakingNews.getPublishedAt().substring(0,10));
    }
}