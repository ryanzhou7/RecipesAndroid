package com.example.ryanzhouold.bakingandroid;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements RecipeListFragment.OnFragmentInteractionListener{

    private RecipeListFragment mRecipeListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipeListFragment = new RecipeListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.recipe_list_container, mRecipeListFragment).commit();
        /*
        mRecipesList = findViewById(R.id.rv_recipes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecipesList.setLayoutManager(linearLayoutManager);
        mLoadingIndicator = findViewById(R.id.progressBar);
        mLoadingIndicator.setVisibility(View.GONE);
        getSupportLoaderManager().initLoader(RECIPES_LOADER_ID, null, this);
        */
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
