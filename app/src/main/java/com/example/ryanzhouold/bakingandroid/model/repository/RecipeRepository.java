package com.example.ryanzhouold.bakingandroid.model.repository;

import com.example.ryanzhouold.bakingandroid.model.remote.RecipeWebservice;
import com.loopj.android.http.AsyncHttpResponseHandler;

import javax.inject.Inject;
import javax.inject.Singleton;

//@Singleton
public class RecipeRepository implements RecipeDataSource{

    private RecipeDataSource mRecipeDataSource;

    //@Inject
    public RecipeRepository(RecipeDataSource recipeDataSource){
        this.mRecipeDataSource = recipeDataSource;
    }

    @Override
    public void getRecipeData(AsyncHttpResponseHandler responseHandler) {
        mRecipeDataSource.getRecipeData(responseHandler);
    }

    //private final webservice
    //private final Dao
    //private final Executor

}
