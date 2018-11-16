package com.example.ryanzhouold.bakingandroid;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ryanzhouold.bakingandroid.RecipeDetail.RecipeStepFragment;
import com.example.ryanzhouold.bakingandroid.RecipeList.RecipeListFragment;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Recipe;

public class MainActivity extends AppCompatActivity implements RecipeListFragment.OnFragmentInteractionListener{

    private RecipeListFragment mRecipeListFragment;
    private RecipeStepFragment mRecipeStepFragment;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTwoPane = getResources().getBoolean(R.bool.isTabletOrLarger);
        if(mTwoPane){
            mRecipeListFragment = new RecipeListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.left_container, mRecipeListFragment).commit();
        }
        else{
            mRecipeListFragment = new RecipeListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recipe_list_container, mRecipeListFragment).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRecipesLoaded(Recipe recipe) {
        if(mTwoPane){
            mRecipeStepFragment = RecipeStepFragment.newInstance("", recipe);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.right_container, mRecipeStepFragment)
                    .commit();
        }
    }

    @Override
    public void onRecipeClicked(Recipe recipe) {
        mRecipeStepFragment = RecipeStepFragment.newInstance("", recipe);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recipe_list_container, mRecipeStepFragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_ENTER_MASK)
                .addToBackStack(RecipeStepFragment.class.getSimpleName())
                .commit();
    }
}
