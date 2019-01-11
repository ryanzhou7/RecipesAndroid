package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindBool;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseActivity;
import com.example.ryanzhouold.bakingandroid.ui.recipeDetail.RecipeDetailActivity;
import com.example.ryanzhouold.bakingandroid.data.constants.Keys;

public class RecipeListActivity extends BaseActivity implements RecipeFragment.OnListFragmentInteractionListener{

    private RecipeFragment mRecipeListFragment;
    @BindView(R.id.activity_recipe_list_toolbar) Toolbar mToolbar;
    @BindInt(R.integer.numCols) int mNumCols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        setUnBinder(ButterKnife.bind(this));
        setSupportActionBar(mToolbar);
        mRecipeListFragment = RecipeFragment.newInstance(mNumCols);
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
