package com.example.ryanzhouold.bakingandroid;

import android.support.v4.app.LoaderManager;

public interface RecipeListContract {
    interface View extends BaseView<Presenter>{
        void showRecipes(String data);
    }
    interface Presenter extends BasePresenter{
        int RECIPES_LOADER_ID = 100;
        void loadRecipes(LoaderManager manager);
    }
}
