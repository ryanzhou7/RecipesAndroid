package com.example.ryanzhouold.bakingandroid.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
