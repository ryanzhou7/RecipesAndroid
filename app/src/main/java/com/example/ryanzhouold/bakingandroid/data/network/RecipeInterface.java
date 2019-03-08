package com.example.ryanzhouold.bakingandroid.data.network;

import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeInterface {

    @GET("/baking.json")
    Call<List<RecipeDto>> getJson();
}
