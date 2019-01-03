package com.example.ryanzhouold.bakingandroid.model.repository;

import com.example.ryanzhouold.bakingandroid.model.dto.RecipeDto;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

public interface RecipeDataSource {
    void getRecipeData(AsyncHttpResponseHandler responseHandler);
    void saveRecipes(List<RecipeDto> recipeDtos);

}
