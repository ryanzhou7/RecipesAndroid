package com.example.ryanzhouold.bakingandroid.RecipeDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.RecipeList.RecipeListFragment;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Recipe;

public class RecipeDetailActivity extends AppCompatActivity{
    private TextView mTVStep;
    private Recipe mRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_recipe);
        mTVStep = findViewById(R.id.tv_step);
        Intent intent = getIntent();
        if(intent.hasExtra(RecipeListFragment.RECIPE_KEY)){
            mRecipe = intent.getParcelableExtra(RecipeListFragment.RECIPE_KEY);
            mTVStep.setText(mRecipe.toString());
        }

    }
}
