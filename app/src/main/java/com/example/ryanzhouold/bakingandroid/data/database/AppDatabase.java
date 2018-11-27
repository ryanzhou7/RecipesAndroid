package com.example.ryanzhouold.bakingandroid.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ryanzhouold.bakingandroid.data.Dao.StepDao;
import com.example.ryanzhouold.bakingandroid.data.entity.Step;

@Database(entities = {Step.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StepDao stepDao();
}
