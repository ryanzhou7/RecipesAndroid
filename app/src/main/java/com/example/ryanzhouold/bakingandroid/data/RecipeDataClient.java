package com.example.ryanzhouold.bakingandroid.data;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class RecipeDataClient {
    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    private static String mCache;
    private static AsyncHttpClient client = new AsyncHttpClient();
    public static void getRecipeData(AsyncHttpResponseHandler responseHandler) {
        client.get(BASE_URL, responseHandler);
    }
}
