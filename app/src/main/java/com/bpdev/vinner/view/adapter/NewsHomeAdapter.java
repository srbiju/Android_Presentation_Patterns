package com.bpdev.vinner.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bpdev.vinner.R;
import com.bpdev.vinner.model.datamodel.Article;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsHomeAdapter extends RecyclerView.Adapter<NewsHomeAdapter.NewsViewHolder> {

    private Context context;
    private List<Article> newsList;

    public NewsHomeAdapter(Context context, List<Article> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_recycler_items, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {

        holder.newsTitle.setText(newsList.get(position).getTitle());
        holder.newsAuthor.setText(newsList.get(position).getAuthor());
        holder.newsPublishedTime.setText(newsList.get(position).getPublishedAt());
        holder.newsDescription.setText(newsList.get(position).getDescription());

        Glide.with(context).load(newsList.get(position).getUrlToImage()).into(holder.newsImage);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView newsImage;
        TextView newsTitle, newsPublishedTime, newsDescription, newsAuthor;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImage = itemView.findViewById(R.id.movie_image);
            newsTitle = itemView.findViewById(R.id.movie_name);
            newsPublishedTime = itemView.findViewById(R.id.movie_year);
            newsDescription = itemView.findViewById(R.id.movie_id);
            newsAuthor = itemView.findViewById(R.id.movie_type);

        }
    }
}
