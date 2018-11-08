package com.example.ryanzhouold.bakingandroid;

public interface RecipeListContract {
    interface View{
        void showRecipes();
    }
    interface Presenter{
        void onClickRecipe();
    }
}
