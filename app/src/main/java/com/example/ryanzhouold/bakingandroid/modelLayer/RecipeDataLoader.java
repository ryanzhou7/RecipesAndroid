package com.example.ryanzhouold.bakingandroid.modelLayer;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecipeDataLoader extends AsyncTaskLoader<String> {

    private final static String RECIPES_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

    public String getmCacheResult() {
        return mCacheResult;
    }

    private String mCacheResult = null;

    public RecipeDataLoader(@NonNull Context context) {
        super(context);
    }

    private URL from(String string){
        Uri uri = Uri.parse(string).buildUpon().build();
        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getDataFrom(URL url){
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        Request request = builder.build();
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onStartLoading() {
        if(mCacheResult==null){
            forceLoad();
        }
        else{
            deliverResult(mCacheResult);
        }
    }
    @Override
    public String loadInBackground() {
        return getDataFrom(from(RECIPES_URL));
    }

    @Override
    public void deliverResult(String jsonResult) {
        mCacheResult = jsonResult;
        super.deliverResult(jsonResult);
    }
}
