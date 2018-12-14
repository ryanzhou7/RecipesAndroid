package com.example.ryanzhouold.bakingandroid.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ryanzhouold.bakingandroid.model.dao.IngredientDao;
import com.example.ryanzhouold.bakingandroid.model.dao.RecipeDao;
import com.example.ryanzhouold.bakingandroid.model.dao.StepDao;
import com.example.ryanzhouold.bakingandroid.model.pojo.Ingredient;
import com.example.ryanzhouold.bakingandroid.model.pojo.Recipe;
import com.example.ryanzhouold.bakingandroid.model.pojo.Step;

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