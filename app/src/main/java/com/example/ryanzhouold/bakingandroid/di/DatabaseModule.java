package com.example.ryanzhouold.bakingandroid.di;

import android.app.Application;

import com.example.ryanzhouold.bakingandroid.data.database.AppDatabase;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    AppDatabase providesAppDatabase(Application application){
        return Room.databaseBuilder(application,
                AppDatabase.class, "database-name").build();
    }
}
