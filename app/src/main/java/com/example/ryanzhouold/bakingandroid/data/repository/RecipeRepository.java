package com.example.ryanzhouold.bakingandroid.data.repository;

import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

//@Singleton
public class RecipeRepository implements RecipeDataSource{

    private RecipeDataSource mRecipeDataSource;

    //@Inject
    public RecipeRepository(RecipeDataSource recipeDataSource){
        this.mRecipeDataSource = recipeDataSource;
    }

    @Override
    public void getRecipeData(AsyncHttpResponseHandler responseHandler) {
        mRecipeDataSource.getRecipeData(responseHandler);
    }

    @Override
    public void saveRecipes(List<RecipeDto> recipeDtos) {

    }

    public void convertToPojoFrom(List<RecipeDto> recipeDtos){
    }

    public List<RecipeDto> convertToDtoFrom(String data){
        if(data!=null) {
            Gson gson = new Gson();
            return gson.fromJson(data, new TypeToken<List<RecipeDto>>(){}.getType());
        }
        return null;
    }
    //private final webservice
    //private final Dao
    //private final Executor

}
