package com.example.ryanzhouold.bakingandroid.RecipeList;

import android.support.annotation.NonNull;

import com.example.ryanzhouold.bakingandroid.data.RecipeDataClient;
import com.example.ryanzhouold.bakingandroid.data.entity.Recipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RecipeListPresenter implements RecipeListContract.Presenter{

    private RecipeListContract.View mViewListener;

    RecipeListPresenter(@NonNull RecipeListContract.View view){
        mViewListener = view;
    }


    @Override
    public void loadRecipes() {
        RecipeDataClient.getRecipeData(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray data) {
                mViewListener.showRecipes(from(data.toString()));
            }
        });

    }

    private List<Recipe> from(String data){
        if(data!=null) {
            Gson gson = new Gson();
            List<Recipe> recipes = gson.fromJson(data, new TypeToken<List<Recipe>>(){}.getType());
            return recipes;
        }
        return null;
    }

    @Override
    public void start() {

    }
}
