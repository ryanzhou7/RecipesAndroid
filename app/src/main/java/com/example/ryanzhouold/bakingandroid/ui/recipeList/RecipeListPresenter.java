package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import com.example.ryanzhouold.bakingandroid.data.database.AppDatabase;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.data.repository.RecipeRepository;
import com.example.ryanzhouold.bakingandroid.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

public class RecipeListPresenter<V extends RecipeListContract.View> extends BasePresenter<V>
        implements RecipeListContract.Presenter<V>{
    private RecipeListContract.View mViewListener;
    private final RecipeRepository mRecipeRepository;

    @Inject
    AppDatabase db;

    RecipeListPresenter(RecipeRepository recipeRepository){
        mRecipeRepository = recipeRepository;

    }

    @Override
    public void loadRecipes() {
        /*
        mRecipeRepository.getRecipeData(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray data) {
                List<RecipeDto> recipes = mRecipeRepository.convertToDtoFrom(data.toString());
                //mViewListener.showRecipes(recipes);
                //TODO cache data
            }
        });
        */
    }

    @Override
    public void saveRecipes(List<RecipeDto> recipeDtos) {
        if(recipeDtos !=null){
            //mRecipeRepository
        }
    }
}
