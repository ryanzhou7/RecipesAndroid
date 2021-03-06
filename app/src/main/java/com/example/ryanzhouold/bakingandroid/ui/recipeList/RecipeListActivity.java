package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindBool;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.data.dao.IngredientDao;
import com.example.ryanzhouold.bakingandroid.data.database.AppDatabase;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.data.network.RecipeWebService2;
import com.example.ryanzhouold.bakingandroid.data.pojo.Recipe;
import com.example.ryanzhouold.bakingandroid.di.AppComponent;
import com.example.ryanzhouold.bakingandroid.di.RecipeApp;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseActivity;
import com.example.ryanzhouold.bakingandroid.ui.recipeDetail.RecipeDetailActivity;
import com.example.ryanzhouold.bakingandroid.data.constants.Keys;

import java.util.List;

import javax.inject.Inject;

public class RecipeListActivity extends BaseActivity implements RecipeFragment.OnListFragmentInteractionListener{

    private RecipeFragment mRecipeListFragment;
    @BindView(R.id.activity_recipe_list_toolbar) Toolbar mToolbar;
    @BindInt(R.integer.numCols) int mNumCols;

    @Inject
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        setUnBinder(ButterKnife.bind(this));
        setSupportActionBar(mToolbar);
        /*
        mRecipeListFragment = RecipeFragment.newInstance(mNumCols);
        RecipeListContract.Presenter p = new RecipeListPresenter(null);
        //mRecipeListFragment.
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, mRecipeListFragment).commit();
        */
        ((RecipeApp) getApplication()).getAppComponent().inject(this);
        //appDatabase.recipeDao().findAll();

    }

    @Override
    public void onListFragmentInteraction(RecipeDto item) {
        Intent detailedRecipeIntent = new Intent(this, RecipeDetailActivity.class);
        detailedRecipeIntent.putExtra(Keys.RECIPE_KEY, item);
        startActivity(detailedRecipeIntent);
    }
}
