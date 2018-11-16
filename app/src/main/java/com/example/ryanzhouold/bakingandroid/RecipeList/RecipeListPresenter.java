package com.example.ryanzhouold.bakingandroid.RecipeList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.ryanzhouold.bakingandroid.modelLayer.RecipeDataLoader;

public class RecipeListPresenter implements RecipeListContract.Presenter, LoaderManager.LoaderCallbacks<String>{

    private RecipeListContract.View mViewListener;
    private RecipeDataLoader mRecipeDataLoader;

    RecipeListPresenter(@NonNull RecipeListContract.View view, RecipeDataLoader recipeDataLoader){
        mViewListener = view;
        mRecipeDataLoader = recipeDataLoader;
    }

    //CreateLoader
    @Override
    public void loadRecipes(LoaderManager loaderManager){
        loaderManager.initLoader(RECIPES_LOADER_ID, null, this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return mRecipeDataLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if(loader.getId()==RECIPES_LOADER_ID){
            mViewListener.showRecipes(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    @Override
    public void start() {

    }
}
