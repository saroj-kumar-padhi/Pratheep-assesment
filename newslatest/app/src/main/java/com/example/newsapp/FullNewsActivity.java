package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.Models.BreakingNews;
import com.squareup.picasso.Picasso;

public class FullNewsActivity extends AppCompatActivity {
   BreakingNews breakingNews;
   TextView detail_author,detail_content,detail_descript,detail_date,detail_title;
   ImageView detail_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);
        detail_author = findViewById(R.id.detail_author);
        detail_descript = findViewById(R.id.detail_descript);
        detail_content = findViewById(R.id.detail_content);
        breakingNews = (BreakingNews) getIntent().getSerializableExtra("data");
        detail_img = findViewById(R.id.detail_img);
        detail_title = findViewById(R.id.detail_title);
        detail_date = findViewById(R.id.detail_date);

        breakingNews = (BreakingNews) getIntent().getSerializableExtra("data");

        detail_author.setText(breakingNews.getAuthor());
        detail_descript.setText(breakingNews.getDescription());
        detail_content.setText(breakingNews.getContent());
        detail_date.setText(breakingNews.getPublishedAt().substring(0,10));
        detail_title.setText(breakingNews.getTitle());
        Picasso.get().load(breakingNews.getUrlToImage()).into(detail_img);
    }
}