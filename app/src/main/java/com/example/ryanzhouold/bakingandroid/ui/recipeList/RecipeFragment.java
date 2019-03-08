package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.data.network.RecipeWebService2;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseFragment;

import java.util.List;

public class RecipeFragment extends BaseFragment implements RecipeListContract.View<RecipeDto>,
        Callback<List<RecipeDto>> {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    @BindView(R.id.recycler_recipes) RecyclerView mRecyclerView;
    @BindView(R.id.progressBar_load_recipes) ProgressBar mProgressBar;

    private OnListFragmentInteractionListener mListener;

    private RecipeListContract.Presenter<RecipeListContract.View> mPresenter;
    private List<RecipeDto> mRecipesCache;

    public RecipeFragment() {}

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RecipeFragment newInstance(int columnCount) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        //mPresenter = new RecipeListPresenter(new BaseRepository());
        //new RecipeWebservice()));
        RecipeWebService2.getJson(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        /*
        mPresenter.onAttachTo(this);
        mPresenter.loadRecipes();
        */
        // Set the adapter
        if (mColumnCount <= 1) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), mColumnCount));
        }
        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        mPresenter.saveRecipes(mRecipesCache);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showRecipes(List<RecipeDto> recipeDtos) {
        MyRecipeRecyclerViewAdapter recipeRecyclerViewAdapter =
                new MyRecipeRecyclerViewAdapter(recipeDtos, mListener);
        mRecyclerView.setAdapter(recipeRecyclerViewAdapter);
        mProgressBar.setVisibility(View.GONE);
        mRecipesCache = recipeDtos;
    }

    //@Override
    public void setPresenter(Object o) {

    }

    @Override
    public void onResponse(Call<List<RecipeDto>> call, Response<List<RecipeDto>> response) {
        Log.w("Recipe", "response");
        showRecipes(response.body());
        Log.w("Recipe", response.body().get(0).getName());
    }

    @Override
    public void onFailure(Call<List<RecipeDto>> call, Throwable t) {
        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(RecipeDto item);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


}
