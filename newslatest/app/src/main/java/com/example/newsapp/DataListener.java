package com.example.newsapp;

import com.example.newsapp.Models.BreakingNews;

import java.util.List;

public interface DataListener<NewsApiResponse> {
     void onFetchData(List<BreakingNews> list, String message);
     void onError(String message);
}
