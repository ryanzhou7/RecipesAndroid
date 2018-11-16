package com.example.ryanzhouold.bakingandroid.RecipeList;

import android.support.v4.app.LoaderManager;

import com.example.ryanzhouold.bakingandroid.BasePresenter;
import com.example.ryanzhouold.bakingandroid.BaseView;

public interface RecipeListContract {
    interface View extends BaseView<Presenter> {
        void showRecipes(String data);
    }
    interface Presenter extends BasePresenter {
        int RECIPES_LOADER_ID = 100;
        void loadRecipes(LoaderManager manager);
    }
}
