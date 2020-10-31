package com.bpdev.vinner.view.viewinterface;

import com.bpdev.vinner.model.datamodel.Article;

import java.util.List;

/**
 * Created by srbijurs on 26-10-2020.
 */

public interface HomeView {
    void updateUIWithNewsData(List<Article> newsList);
    void updateUIWithErrorMessage(String errorMessage);
}
