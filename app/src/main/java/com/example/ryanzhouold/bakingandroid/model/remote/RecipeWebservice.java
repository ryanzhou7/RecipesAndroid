package com.example.ryanzhouold.bakingandroid.model.remote;

import com.example.ryanzhouold.bakingandroid.model.repository.RecipeDataSource;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import javax.inject.Singleton;

@Singleton
public class RecipeWebservice implements RecipeDataSource {
    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    private static AsyncHttpClient client = new AsyncHttpClient();
    public void getRecipeData(AsyncHttpResponseHandler responseHandler) {
        client.get(BASE_URL, responseHandler);
    }
}
