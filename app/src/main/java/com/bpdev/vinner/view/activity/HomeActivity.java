package com.bpdev.vinner.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.bpdev.vinner.R;
import com.bpdev.vinner.interactors.HomeInteractorImpl;
import com.bpdev.vinner.interactors.IHomeInteractor;
import com.bpdev.vinner.model.datamodel.Article;
import com.bpdev.vinner.presenter.HomePresenter;
import com.bpdev.vinner.view.viewinterface.HomeView;
import com.bpdev.vinner.view.adapter.NewsHomeAdapter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeActivity extends AppCompatActivity implements HomeView {
    private HomePresenter homePresenter;
    private IHomeInteractor homeInteractor;
    private RecyclerView featuredRecyclerView;
    private NewsHomeAdapter featuredAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        featuredRecyclerView = findViewById(R.id.featured_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        featuredRecyclerView.setLayoutManager(layoutManager);

        homeInteractor = new HomeInteractorImpl();
        homePresenter = new HomePresenter(homeInteractor);
        homePresenter.bindView(this);
        homePresenter.populateHomeData();
    }

    @Override
    public void updateUIWithNewsData(List<Article> newsList) {
        featuredAdapter = new NewsHomeAdapter(this, newsList);
        featuredRecyclerView.setAdapter(featuredAdapter);
        featuredAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateUIWithErrorMessage(String errorMessage) {
        Toast.makeText(HomeActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        homePresenter.unbindView();
        super.onDestroy();
    }
}

