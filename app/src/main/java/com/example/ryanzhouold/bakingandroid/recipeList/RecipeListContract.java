package com.example.ryanzhouold.bakingandroid.recipeList;

import com.example.ryanzhouold.bakingandroid.baseContract.BasePresenter;
import com.example.ryanzhouold.bakingandroid.baseContract.BaseView;
import com.example.ryanzhouold.bakingandroid.data.entity.Recipe;

import java.util.List;

public interface RecipeListContract {
    interface View extends BaseView<Presenter> {
        void showRecipes(List<Recipe> recipes);
    }
    interface Presenter extends BasePresenter {
        void loadRecipes();
    }
}
