package com.example.ryanzhouold.bakingandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ryanzhouold.bakingandroid.model.Recipe;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private TextView mTVName;
    public RecipeViewHolder(View itemView) {
        super(itemView);
        mTVName = itemView.findViewById(R.id.tv_recipe_list_item);
    }
    void bind(Recipe recipe){
        mTVName.setText(recipe.getName());
    }
}
