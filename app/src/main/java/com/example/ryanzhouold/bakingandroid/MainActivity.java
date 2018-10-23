package com.example.ryanzhouold.bakingandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ryanzhouold.bakingandroid.model.Recipe;
import com.example.ryanzhouold.bakingandroid.model.Step;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, RecipeAdapter.ListItemOnClickHandler {
    private final static int RECIPES_LOADER_ID = 100;
    private final static String RECIPES_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    public final static String STEP_KEY = "STEP_KEY";
    public final static String RECIPE_KEY = "RECIPE_KEY";
    private List<Recipe> mRecipes;
    private final String TAG = getClass().getName();
    private RecyclerView mRecipesList;
    private ProgressBar mLoadingIndicator;
    private RecipeAdapter mRecipeAdapter;

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            private String mCacheResult = null;
            @Override
            protected void onStartLoading() {
                mLoadingIndicator.setVisibility(View.VISIBLE);
                if(mCacheResult==null){
                    forceLoad();
                }
                else{
                    deliverResult(mCacheResult);
                }
            }
            @Override
            public String loadInBackground() {
                return getDataFrom(from(RECIPES_URL));
            }
            @Override
            public void deliverResult(String jsonResult) {
                mCacheResult = jsonResult;
                super.deliverResult(jsonResult);
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if(loader.getId()==RECIPES_LOADER_ID) {
            updateListWith(data);
            mLoadingIndicator.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
    }

    private URL from(String string){
        Uri uri = Uri.parse(string).buildUpon().build();
        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getDataFrom(URL url){
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        Request request = builder.build();
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void updateListWith(String data){
        if(data!=null) {
            Gson gson = new Gson();
            mRecipes = gson.fromJson(data, new TypeToken<List<Recipe>>(){}.getType());
            mRecipeAdapter = new RecipeAdapter(mRecipes, this);
            mRecipesList.setAdapter(mRecipeAdapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipesList = findViewById(R.id.rv_recipes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecipesList.setLayoutManager(linearLayoutManager);
        mLoadingIndicator = findViewById(R.id.progressBar);
        mLoadingIndicator.setVisibility(View.GONE);
        getSupportLoaderManager().initLoader(RECIPES_LOADER_ID, null, this);
    }

    @Override
    public void onListItemClick(int index) {
        Recipe recipe = mRecipeAdapter.getRecipes().get(index);
        Intent detailedRecipeIntent = new Intent(this, DetailedRecipeActivity.class);
        detailedRecipeIntent.putExtra(RECIPE_KEY, recipe);
        startActivity(detailedRecipeIntent);
    }
}
