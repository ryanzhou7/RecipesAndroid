package com.example.ryanzhouold.bakingandroid.view.recipeList;

import com.example.ryanzhouold.bakingandroid.BasePresenter;
import com.example.ryanzhouold.bakingandroid.BaseView;
import com.example.ryanzhouold.bakingandroid.model.dto.Recipe;

import java.util.List;

public interface RecipeListContract {
    interface View extends BaseView<Presenter> {
        void showRecipes(List<Recipe> recipes);
    }
    interface Presenter extends BasePresenter {
        void loadRecipes();
    }
}
