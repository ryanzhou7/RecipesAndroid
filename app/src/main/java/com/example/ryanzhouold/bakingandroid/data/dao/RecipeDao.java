package com.example.ryanzhouold.bakingandroid.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.example.ryanzhouold.bakingandroid.data.entity.Recipe;

@Dao
public interface RecipeDao {

    @Insert
    public void insertRecipes(Recipe... recipes);

    @Update
    public void updateUsers(Recipe... recipes);
}
