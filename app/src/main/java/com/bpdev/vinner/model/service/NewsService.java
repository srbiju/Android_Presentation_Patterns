package com.bpdev.vinner.model.service;

import com.bpdev.vinner.model.datamodel.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("top-headlines")
    Call<News> getNews(@Query("country") String country ,
                       @Query("apikey") String apikey);

}
