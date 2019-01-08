package com.example.ryanzhouold.bakingandroid.view.recipeList;

import androidx.annotation.NonNull;

import com.example.ryanzhouold.bakingandroid.model.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.model.repository.RecipeRepository;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RecipeListPresenter implements RecipeListContract.Presenter{

    private RecipeListContract.View mViewListener;
    private final RecipeRepository mRecipeRepository;

    //@Inject
    RecipeListPresenter(@NonNull RecipeListContract.View view, RecipeRepository recipeRepository){
        mViewListener = view;
        mRecipeRepository = recipeRepository;
    }

    @Override
    public void loadRecipes() {
        mRecipeRepository.getRecipeData(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray data) {
                if(mViewListener!=null){
                    List<RecipeDto> recipes = mRecipeRepository.convertToDtoFrom(data.toString());
                    //mViewListener.showRecipes();
                }
                //TODO cache data
            }
        });

    }

    @Override
    public void saveRecipes(List<RecipeDto> recipeDtos) {
        if(recipeDtos !=null){
            //mRecipeRepository
        }
    }

    @Override
    public void start() {

    }
}
