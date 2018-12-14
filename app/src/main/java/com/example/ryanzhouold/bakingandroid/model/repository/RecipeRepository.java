package com.example.ryanzhouold.bakingandroid.model.repository;

import com.example.ryanzhouold.bakingandroid.model.remote.RecipeWebservice;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class RecipeRepository implements RecipeDataSource {

    private RecipeWebservice mRecipeWebservice;

    public RecipeRepository(){
        this.mRecipeWebservice = new RecipeWebservice();
    }

    @Override
    public void getRecipeData(AsyncHttpResponseHandler responseHandler) {
        //Decide to get recipe data from network or local
        mRecipeWebservice.getRecipeData(responseHandler);
    }

    //private final webservice
    //private final Dao
    //private final Executor

}
