package com.example.ryanzhouold.bakingandroid.RecipeDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.StepFragment;
import com.example.ryanzhouold.bakingandroid.dummy.DummyContent;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Recipe;

public class RecipeDetailActivity extends AppCompatActivity implements StepFragment.OnListFragmentInteractionListener{
    private TextView mTVStep;
    private Recipe mRecipe;
    private boolean mTwoPane;
    private StepFragment mStepFragment;
    private int mNUM_COL_FOR_STEPS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_recipe);
        Intent intent = getIntent();
        /*
        if(intent.hasExtra(RecipeFragment.RECIPE_KEY)){
            mRecipe = intent.getParcelableExtra(RecipeFragment.RECIPE_KEY);
        }
        mTwoPane = getResources().getBoolean(R.bool.isTabletOrLarger);
        if(mTwoPane){

        }
        else{
            mStepFragment = StepFragment.newInstance(mNUM_COL_FOR_STEPS);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailed_main_container, mStepFragment)
                    .commit();
        }
        */
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
