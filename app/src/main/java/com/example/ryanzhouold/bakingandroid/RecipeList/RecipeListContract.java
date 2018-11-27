package com.example.ryanzhouold.bakingandroid.RecipeList;

import com.example.ryanzhouold.bakingandroid.BasePresenter;
import com.example.ryanzhouold.bakingandroid.BaseView;
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
