package com.bpdev.vinner.interactors;

import com.bpdev.vinner.model.datamodel.News;

import retrofit2.Call;

public interface IHomeInteractor {

    Call<News> getNews(String country, String apikey);

}
