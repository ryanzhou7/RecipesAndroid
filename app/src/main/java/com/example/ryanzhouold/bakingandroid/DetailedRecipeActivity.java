package com.example.ryanzhouold.bakingandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.model.Recipe;
import com.example.ryanzhouold.bakingandroid.model.Step;

public class DetailedRecipeActivity extends AppCompatActivity {
    private TextView mTVStep;
    private Recipe mRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_recipe);
        mTVStep = findViewById(R.id.tv_step);
        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.RECIPE_KEY)){
            mRecipe = intent.getParcelableExtra(MainActivity.RECIPE_KEY);
            mTVStep.setText(mRecipe.toString());
        }

    }

}
