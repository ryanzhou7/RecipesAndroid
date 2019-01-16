package com.example.ryanzhouold.bakingandroid.data.repository;

import com.example.ryanzhouold.bakingandroid.data.dao.RecipeDao;
import com.example.ryanzhouold.bakingandroid.data.dto.RecipeDto;
import com.example.ryanzhouold.bakingandroid.data.pojo.Recipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class RecipeRepository extends BaseRepository implements LocalRepository<Long, Recipe>,
        RemoteRepository<RecipeDto> {
    private RecipeDao mRecipeDao;
    public RecipeRepository(){
        //super();
        this.mRecipeDao = super.mAppDatabase.recipeDao();
    }

    public List<RecipeDto> convertToDtoFrom(String data){
        if(data!=null) {
            Gson gson = new Gson();
            return gson.fromJson(data, new TypeToken<List<RecipeDto>>(){}.getType());
        }
        return null;
    }


    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findById(Long id) {
        return mRecipeDao.findById(id);
    }

    @Override
    public Recipe create(Recipe... entity) {
        return mRecipeDao.insert(entity);
    }

    @Override
    public Recipe update(Recipe... entity) {
        return mRecipeDao.update(entity);
    }

    @Override
    public void delete(Recipe... entity) {
        mRecipeDao.delete(entity);
    }


    @Override
    public List<RecipeDto> getAll() {
        return null;
    }
}
