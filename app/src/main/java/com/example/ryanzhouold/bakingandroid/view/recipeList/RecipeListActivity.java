package com.example.ryanzhouold.bakingandroid.view.recipeList;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.model.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.view.recipeDetail.RecipeDetailActivity;
import com.example.ryanzhouold.bakingandroid.model.constants.Keys;

public class RecipeListActivity extends AppCompatActivity implements RecipeFragment.OnListFragmentInteractionListener{

    private RecipeFragment mRecipeListFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mToolbar = findViewById(R.id.activity_recipe_list_toolbar);
        setSupportActionBar(mToolbar);
        mRecipeListFragment = RecipeFragment.newInstance(getResources().getInteger(R.integer.numCols));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, mRecipeListFragment).commit();
    }

    @Override
    public void onListFragmentInteraction(RecipeDto item) {
        Intent detailedRecipeIntent = new Intent(this, RecipeDetailActivity.class);
        detailedRecipeIntent.putExtra(Keys.RECIPE_KEY, item);
        startActivity(detailedRecipeIntent);
    }
}
