package com.example.ryanzhouold.bakingandroid;

import android.support.v4.app.Fragment;

public interface RecipeListContract {
    interface View{
        void showRecipes(String data);
    }
    interface Presenter{
        void loadRecipes();
    }
}
