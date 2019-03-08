package com.example.ryanzhouold.bakingandroid.data.network;

import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;

import java.util.List;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeWebService2 {
    private final static String baseUrl = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking";
    public static void getJson(Callback<List<RecipeDto>> callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        RecipeInterface recipeInterface = retrofit.create(RecipeInterface.class);
        recipeInterface.getJson().enqueue(callback);
    }
}
