package com.example.ryanzhouold.bakingandroid;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

public class RecipeListPresenter implements RecipeListContract.Presenter, LoaderManager.LoaderCallbacks<String>{

    private final static int RECIPES_LOADER_ID = 100;

    private RecipeListContract.View mViewListener;
    RecipeListPresenter(@NonNull RecipeListContract.View view){
        mViewListener = view;
    }

    //CreateLoader
    @Override
    public void loadRecipes() {
        ((Fragment)mViewListener).getLoaderManager().initLoader(RECIPES_LOADER_ID, null, this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new RecipeDataLoader(((Fragment) mViewListener).getContext());
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
}
