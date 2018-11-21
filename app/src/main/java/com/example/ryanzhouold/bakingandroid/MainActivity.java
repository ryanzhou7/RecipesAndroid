package com.example.ryanzhouold.bakingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ryanzhouold.bakingandroid.RecipeList.RecipeFragment;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Recipe;

public class MainActivity extends AppCompatActivity implements RecipeFragment.OnListFragmentInteractionListener{

    private RecipeFragment mRecipeListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipeListFragment = RecipeFragment.newInstance(1);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, mRecipeListFragment).commit();
    }

    @Override
    public void onListFragmentInteraction(Recipe item) {
        /*
        Recipe recipe = mRecipeAdapter.getRecipes().get(index);
        Intent detailedRecipeIntent = new Intent(getActivity(), RecipeDetailActivity.class);
        detailedRecipeIntent.putExtra(RECIPE_KEY, recipe);
        startActivity(detailedRecipeIntent);
        */
    }
}
