package com.example.ryanzhouold.bakingandroid.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ryanzhouold.bakingandroid.data.dao.IngredientDao;
import com.example.ryanzhouold.bakingandroid.data.dao.RecipeDao;
import com.example.ryanzhouold.bakingandroid.data.dao.StepDao;
import com.example.ryanzhouold.bakingandroid.data.entity.Ingredient;
import com.example.ryanzhouold.bakingandroid.data.entity.Recipe;
import com.example.ryanzhouold.bakingandroid.data.entity.Step;

@Database(entities = {Recipe.class, Step.class, Ingredient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RecipeDao recipeDao();
    public abstract IngredientDao ingredientDao();
    public abstract StepDao stepDao();

    /*
    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        AppDatabase.class, "database-name").build();
     */
}