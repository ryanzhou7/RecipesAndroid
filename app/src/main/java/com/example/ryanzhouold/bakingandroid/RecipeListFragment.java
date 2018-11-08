package com.example.ryanzhouold.bakingandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipeListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RecipeListFragment extends Fragment implements RecipeListContract.View{

    private OnFragmentInteractionListener mListener;
    private ProgressBar mLoadRecipesProgressBar;
    private RecyclerView mRecipesRecyclerView;

    public RecipeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        mLoadRecipesProgressBar = rootView.findViewById(R.id.progressBar_load_recipes);
        mRecipesRecyclerView = rootView.findViewById(R.id.recycler_recipes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecipesRecyclerView.setLayoutManager(linearLayoutManager);

         /*
        mRecipesList = findViewById(R.id.rv_recipes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecipesList.setLayoutManager(linearLayoutManager);
        mLoadingIndicator = findViewById(R.id.progressBar);
        mLoadingIndicator.setVisibility(View.GONE);
        getSupportLoaderManager().initLoader(RECIPES_LOADER_ID, null, this);
        */

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showRecipes() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
