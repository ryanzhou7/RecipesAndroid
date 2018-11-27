package com.example.ryanzhouold.bakingandroid.recipeList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.recipeDetail.RecipeDetailActivity;
import com.example.ryanzhouold.bakingandroid.constants.Keys;
import com.example.ryanzhouold.bakingandroid.data.entity.Recipe;

public class RecipeListActivity extends AppCompatActivity implements RecipeFragment.OnListFragmentInteractionListener{

    private RecipeFragment mRecipeListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecipeListFragment = RecipeFragment.newInstance(getResources().getInteger(R.integer.numCols));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, mRecipeListFragment).commit();
    }

    @Override
    public void onListFragmentInteraction(Recipe item) {
        Intent detailedRecipeIntent = new Intent(this, RecipeDetailActivity.class);
        detailedRecipeIntent.putExtra(Keys.RECIPE_KEY, item);
        startActivity(detailedRecipeIntent);
    }
}
