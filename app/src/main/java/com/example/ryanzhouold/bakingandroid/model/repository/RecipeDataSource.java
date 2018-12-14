package com.example.ryanzhouold.bakingandroid.model.repository;

import com.loopj.android.http.AsyncHttpResponseHandler;

public interface RecipeDataSource {
    void getRecipeData(AsyncHttpResponseHandler responseHandler);
}
