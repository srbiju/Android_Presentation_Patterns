package com.bpdev.vinner.presenter;

import com.bpdev.vinner.BuildConfig;
import com.bpdev.vinner.model.datamodel.Article;
import com.bpdev.vinner.model.datamodel.News;
import com.bpdev.vinner.interactors.IHomeInteractor;
import com.bpdev.vinner.view.viewinterface.HomeView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by srbijurs on 26-10-2020.
 */

public class HomePresenter {
    private static final String API_KEY = BuildConfig.API_KEY;
    private static final String COUNTRY_CODE = BuildConfig.COUNTRY_CODE;

    private IHomeInteractor homeInteractor;
    private HomeView homeView;

    public HomePresenter(IHomeInteractor homeInteractor){
        this.homeInteractor = homeInteractor;
    }

    public void bindView(HomeView homeView){
        this.homeView = homeView;
    }

    public void unbindView(){
        this.homeView = null;
    }

    public void populateHomeData(){
        Call<News> call = homeInteractor.getNews(COUNTRY_CODE,API_KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News homeData = response.body();
                if(null != homeData.getArticles()) {
                    List<Article> newsList = homeData.getArticles();
                    if (null != homeView)
                        homeView.updateUIWithNewsData(newsList);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                if(null != homeView)
                    homeView.updateUIWithErrorMessage("Server is not responding");
            }
        });
    }
}

