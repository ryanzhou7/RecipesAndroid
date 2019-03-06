package com.example.ryanzhouold.bakingandroid.di;

import com.example.ryanzhouold.bakingandroid.ui.recipeList.RecipeListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {
    void inject(RecipeListActivity activity);
}
