package com.example.ryanzhouold.bakingandroid.data.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.ryanzhouold.bakingandroid.data.entity.Step;

@Dao
public interface StepDao {

    @Insert
    void insertAll(Step... step);
}
