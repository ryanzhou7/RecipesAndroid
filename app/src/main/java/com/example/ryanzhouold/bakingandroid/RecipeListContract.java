package com.example.ryanzhouold.bakingandroid;

import android.support.v4.app.LoaderManager;

public interface RecipeListContract {
    interface View{
        void showRecipes(String data);
    }
    interface Presenter{
        int RECIPES_LOADER_ID = 100;
        void loadRecipes(LoaderManager manager);
    }
}
