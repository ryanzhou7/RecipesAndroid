package com.example.ryanzhouold.bakingandroid.RecipeDetail;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.Step.StepActivity;
import com.example.ryanzhouold.bakingandroid.Step.StepFragment;
import com.example.ryanzhouold.bakingandroid.constants.Keys;
import com.example.ryanzhouold.bakingandroid.data.entity.Recipe;
import com.example.ryanzhouold.bakingandroid.data.entity.Step;
import java.util.Arrays;

public class RecipeDetailActivity extends AppCompatActivity
        implements RecipeFragment.OnListFragmentInteractionListener{
    private TextView mTVStep;
    private Recipe mRecipe;
    private boolean mIsTwoPane;
    private RecipeFragment mRecipeFragment;
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
        mIsTwoPane = getResources().getBoolean(R.bool.isTabletOrLarger);
        mRecipeFragment = RecipeFragment.newInstance(mNUM_COL, mRecipe);
        if(mIsTwoPane){
            //left and right
            addFragmentTo(mRecipeFragment, R.id.left_container);
            mStepFragment = StepFragment.newInstance(mIsTwoPane, Arrays.asList(mRecipe.getSteps()));
            addFragmentTo(mStepFragment, R.id.right_container);
        }
        else{
            addFragmentTo(mRecipeFragment, R.id.detailed_main_container);
        }
    }

    private void addFragmentTo(Fragment fragment, int container){
        getSupportFragmentManager().beginTransaction()
                .add(container, fragment)
                .commit();
    }

    @Override
    public void onClick(Step item) {
        if(mIsTwoPane) {
            mStepFragment.showStep(item);
        }
        else{
            Intent stepIntent = new Intent(getApplicationContext(), StepActivity.class);
            stepIntent.putExtra(Keys.STEP_KEY, mRecipe.getSteps());
            startActivity(stepIntent);
        }
    }

}
