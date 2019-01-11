package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import com.example.ryanzhouold.bakingandroid.ui.base.BaseContract;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;

import java.util.List;

public interface RecipeListContract {
    interface View extends BaseContract.BaseView{
        void showRecipes(List<RecipeDto> recipeDtos);
    }
    interface Presenter<V extends View> extends BaseContract.BasePresenter<V>{
        void loadRecipes();
        void saveRecipes(List<RecipeDto> recipeDtos);
    }
}
