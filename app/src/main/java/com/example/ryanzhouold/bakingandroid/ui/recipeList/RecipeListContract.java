package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import com.example.ryanzhouold.bakingandroid.ui.base.BasePresenter;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseView;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;

import java.util.List;

public interface RecipeListContract {
    interface View extends BaseView<Presenter> {
        void showRecipes(List<RecipeDto> recipeDtos);
    }
    interface Presenter extends BasePresenter {
        void loadRecipes();
        void saveRecipes(List<RecipeDto> recipeDtos);
    }
}
