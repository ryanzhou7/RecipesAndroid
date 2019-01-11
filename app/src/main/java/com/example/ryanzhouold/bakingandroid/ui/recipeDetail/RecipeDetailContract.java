package com.example.ryanzhouold.bakingandroid.ui.recipeDetail;

import com.example.ryanzhouold.bakingandroid.ui.base.BaseContract;

public interface RecipeDetailContract {
    public interface View extends BaseContract.View {
    }
    public interface Presenter<V extends View> extends BaseContract.Presenter<V> {

    }

}
