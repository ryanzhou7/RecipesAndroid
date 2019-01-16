package com.example.ryanzhouold.bakingandroid.data.repository;

import com.example.ryanzhouold.bakingandroid.data.database.AppDatabase;

import javax.inject.Inject;

public class BaseRepository{
    protected AppDatabase mAppDatabase;
    @Inject
    public BaseRepository(AppDatabase appDatabase){
        this.mAppDatabase = appDatabase;
    }

    public BaseRepository() {

    }
}
