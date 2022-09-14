package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.newsapp.Models.BreakingNews;
import com.example.newsapp.Models.NewsApiResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements clickListener{
    RecyclerView recyclerView;
    CustomAdapter adapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                methodManager manager = new methodManager(MainActivity.this);
                manager.getBreakingNews(listener,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        methodManager manager = new methodManager(this);
        manager.getBreakingNews(listener,"business", null);
    }
    private final DataListener<NewsApiResponse> listener = new DataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<BreakingNews> list, String message) {
            if(list.isEmpty())
            {
              // do your code  Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            }
            else
               showNews(list);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<BreakingNews> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onclicked(BreakingNews breakingNews) {
        startActivity(new Intent(MainActivity.this,FullNewsActivity.class)
                .putExtra("data",breakingNews));
    }
    public void onclicked1(BreakingNews breakingNews)
    {
        startActivity(new Intent(MainActivity.this,saved_layout.class)
                .putExtra("data",breakingNews));
    }

}

