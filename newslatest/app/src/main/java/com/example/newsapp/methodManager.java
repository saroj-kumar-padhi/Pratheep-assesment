package com.example.newsapp;

import android.content.Context;
import android.widget.Toast;

import com.example.newsapp.Models.NewsApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class methodManager {

    Context context;
  // creating retrofit object to make request calls
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public void getBreakingNews(DataListener listner, String category, String Query)
    {
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<NewsApiResponse> call = callNewsApi.callHeadlines("in",category,Query, context.getString(R.string.api_key));
        try{
            call.enqueue(new Callback<NewsApiResponse>() {
                @Override
                public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                    if(!response.isSuccessful())
                    {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                    listner.onFetchData(response.body().getArticles(), response.message());
                }

                @Override
                public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                    listner.onError("Request failed");
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public methodManager(Context context) {
        this.context = context;
    }
    public interface CallNewsApi {
        @GET("top-headlines")
        Call<NewsApiResponse> callHeadlines(
             @Query("country") String country,
             @Query("category") String category,
             @Query("q") String query,
             @Query("apikey") String api_key
        );
    }
}
