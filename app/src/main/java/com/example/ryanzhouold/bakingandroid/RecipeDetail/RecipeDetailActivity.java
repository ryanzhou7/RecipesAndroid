package com.example.ryanzhouold.bakingandroid.RecipeDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.constants.Keys;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Recipe;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Step;

public class RecipeDetailActivity extends AppCompatActivity implements StepFragment.OnListFragmentInteractionListener{
    private TextView mTVStep;
    private Recipe mRecipe;
    private boolean mTwoPane;
    private StepFragment mStepFragment;
    private int mNUM_COL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_recipe);
        Intent intent = getIntent();
        if(intent.hasExtra(Keys.RECIPE_KEY)){
            mRecipe = intent.getParcelableExtra(Keys.RECIPE_KEY);
        }
        mTwoPane = getResources().getBoolean(R.bool.isTabletOrLarger);
        if(mTwoPane){
            //left and right
            addStepFragmentTo(R.id.left_container);
        }
        else{
            addStepFragmentTo(R.id.detailed_main_container);
        }
    }

    private void addStepFragmentTo(int container){
        mStepFragment = StepFragment.newInstance(mNUM_COL, mRecipe);
        getSupportFragmentManager().beginTransaction()
                .add(container, mStepFragment)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(Step item) {

    }
}
