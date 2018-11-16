package com.example.ryanzhouold.bakingandroid.RecipeList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> mRecipes;
    ListItemOnClickHandler mListItemOnClickHandler;

    public RecipeAdapter(List<Recipe> recipes, ListItemOnClickHandler listItemOnClickHandler){
        mRecipes = recipes;
        mListItemOnClickHandler = listItemOnClickHandler;
    }

    interface ListItemOnClickHandler {
        void onListItemClick(int index);
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.recipe_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = mRecipes.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }

    public void setRecipes(List<Recipe> mRecipes) {
        this.mRecipes = mRecipes;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTVName;
        public RecipeViewHolder(View itemView) {
            super(itemView);
            mTVName = itemView.findViewById(R.id.tv_recipe_list_item);
            itemView.setOnClickListener(this);

        }
        void bind(Recipe recipe){
            mTVName.setText(recipe.getName());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mListItemOnClickHandler.onListItemClick(position);
        }
    }
}
