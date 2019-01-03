package com.example.ryanzhouold.bakingandroid.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ryanzhouold.bakingandroid.model.pojo.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipe")
    public List<Recipe> findAll();

    @Query("SELECT * FROM recipe WHERE id=:id")
    public Recipe findById(long id);

    @Insert
    public void insert(Recipe... recipes);

    @Update
    public void update(Recipe... recipes);

    @Delete
    public void delete(Recipe... recipes);
}
