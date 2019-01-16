package com.example.ryanzhouold.bakingandroid.data.repository;

import java.util.List;

public interface RemoteRepository<V> {
    List<V> getAll();
}
