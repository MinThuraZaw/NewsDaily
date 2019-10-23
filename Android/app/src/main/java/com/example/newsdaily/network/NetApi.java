package com.example.newsdaily.network;

import com.example.newsdaily.model.Articles;
import com.example.newsdaily.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetApi {


    @GET("/v2/top-headlines?country=us&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getGeneralNews();

    @GET("/v2/top-headlines?country=us&category=technology&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getTechNews();

    @GET("/v2/top-headlines?country=us&category=science&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getScienceNews();

    @GET("/v2/top-headlines?country=us&category=business&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getBusinessNews();

    @GET("/v2/top-headlines?country=us&category=health&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getHealthNews();

    @GET("/v2/top-headlines?country=us&category=sports&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getSportsNews();

    @GET("/v2/top-headlines?country=us&category=entertainment&apiKey=191c922c27044dfe9b0773d6bd6f9a56")
    Call<NewsModel> getEntertainNews();

}
