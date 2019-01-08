package com.example.ryanzhouold.bakingandroid;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import com.example.ryanzhouold.bakingandroid.data.dao.RecipeDao;
import com.example.ryanzhouold.bakingandroid.data.database.AppDatabase;
import com.example.ryanzhouold.bakingandroid.data.pojo.Recipe;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RecipeDaoTests {

    private AppDatabase db;
    private RecipeDao recipeDao;
    private static final String TAG = "RecipeDaoTests";
    @Before
    public void setUp(){
        db = AppDatabase.create(InstrumentationRegistry.getTargetContext(), true);
        recipeDao = db.recipeDao();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void basics(){
        assertThat(recipeDao.findAll().size(), is(0));
        long id = 0;
        String name = "cake";
        int servings = 1;
        String image = "www.image.com";
        Recipe recipe = new Recipe(id, name, servings, image);
        recipeDao.insert(recipe);

        //findAll
        assertThat(recipeDao.findAll().size(), is(1));

        //find one
        Recipe found = recipeDao.findById(0);
        assertThat(isEqual(recipe, found), is(true));

        //update
        name = "pie";
        recipe.setName(name);
        recipeDao.update(recipe);
        found = recipeDao.findById(0);
        assertThat(isEqual(recipe, found), is(true));

        //delete
        assertThat(recipeDao.findAll().size(), is(1));
        recipeDao.delete(recipe);
        assertThat(recipeDao.findAll().size(), is(0));

    }


    private boolean isEqual(Recipe one, Recipe two){
        int result = Long.compare(one.getId(), two.getId());
        result |= one.getName().compareTo(two.getName());
        result |= one.getImage().compareTo(two.getImage());
        result |= Integer.compare(one.getServings(), two.getServings());
        return result==0;
    }

}


