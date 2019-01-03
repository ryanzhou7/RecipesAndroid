package com.example.ryanzhouold.bakingandroid;

import android.app.Instrumentation;

import com.example.ryanzhouold.bakingandroid.model.dao.RecipeDao;
import com.example.ryanzhouold.bakingandroid.model.database.AppDatabase;
import com.example.ryanzhouold.bakingandroid.model.pojo.Recipe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private RecipeDao recipeDao;
    private AppDatabase appDatabase;
    @Before
    public void setUp(){

    }

    @Test
    public void basics() {
        final Recipe recipe = new Recipe(0, "cake", 1, null);
        recipeDao.insert(recipe);

    }

}