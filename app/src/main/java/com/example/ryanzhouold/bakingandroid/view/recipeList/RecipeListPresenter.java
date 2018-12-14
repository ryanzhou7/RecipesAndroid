package com.example.ryanzhouold.bakingandroid.view.recipeList;

import android.support.annotation.NonNull;

import com.example.ryanzhouold.bakingandroid.model.remote.RecipeWebservice;
import com.example.ryanzhouold.bakingandroid.model.dto.Recipe;
import com.example.ryanzhouold.bakingandroid.model.repository.RecipeRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RecipeListPresenter implements RecipeListContract.Presenter{

    private RecipeListContract.View mViewListener;
    private RecipeRepository mRecipeRepository;

    RecipeListPresenter(@NonNull RecipeListContract.View view){
        mViewListener = view;
        mRecipeRepository = new RecipeRepository();
    }

    @Override
    public void loadRecipes() {
        mRecipeRepository.getRecipeData(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray data) {
                if(mViewListener!=null){
                    mViewListener.showRecipes(from(data.toString()));
                }
                //TODO cache data
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
