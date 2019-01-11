package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.data.repository.RecipeRepository;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseContract;
import com.example.ryanzhouold.bakingandroid.ui.base.BasePresenter;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RecipeListPresenter<V extends RecipeListContract.View> extends BasePresenter<V>
        implements RecipeListContract.Presenter<V>{
    private RecipeListContract.View mViewListener;
    private final RecipeRepository mRecipeRepository;

    //@Inject
    RecipeListPresenter(RecipeRepository recipeRepository){
        mRecipeRepository = recipeRepository;
    }

    @Override
    public void loadRecipes() {
        mRecipeRepository.getRecipeData(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray data) {
                List<RecipeDto> recipes = mRecipeRepository.convertToDtoFrom(data.toString());
                //mViewListener.showRecipes();
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
}
