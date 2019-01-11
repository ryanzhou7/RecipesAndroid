package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import com.example.ryanzhouold.bakingandroid.ui.base.BaseContract;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;

import java.util.List;

public interface RecipeListContract {
    interface View<R> extends BaseContract.BaseView{
        void showRecipes(List<R> recipeDtos);
    }
    interface Presenter<V extends View> extends BaseContract.BasePresenter<V>{
        void loadRecipes();
        void saveRecipes(List<RecipeDto> recipeDtos);
    }
}
