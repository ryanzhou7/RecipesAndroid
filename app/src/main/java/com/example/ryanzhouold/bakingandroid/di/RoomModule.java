package com.example.ryanzhouold.bakingandroid.di;

import android.app.Application;

import com.example.ryanzhouold.bakingandroid.data.dao.RecipeDao;
import com.example.ryanzhouold.bakingandroid.data.database.AppDatabase;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private AppDatabase mDatabase;
    public RoomModule(Application mApplication) {
        this.mDatabase = Room.databaseBuilder(mApplication, AppDatabase.class, AppDatabase.DB_NAME)
                .build();
    }

    @Singleton @Provides
    AppDatabase providesRoomDatabase() {
        return mDatabase;
    }

    @Singleton @Provides
    RecipeDao providesProductDao() {
        return mDatabase.recipeDao();
    }

}