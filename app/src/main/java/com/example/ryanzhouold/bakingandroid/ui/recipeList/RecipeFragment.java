package com.example.ryanzhouold.bakingandroid.ui.recipeList;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.data.remote.RecipeWebservice;
import com.example.ryanzhouold.bakingandroid.data.repository.RecipeRepository;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseContract;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseFragment;

import java.util.List;

public class RecipeFragment extends BaseFragment implements RecipeListContract.View<RecipeDto>{

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
        mPresenter = new RecipeListPresenter(new RecipeRepository(new RecipeWebservice()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttachTo(this);
        mPresenter.loadRecipes();
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
