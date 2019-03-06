package com.example.ryanzhouold.bakingandroid.data.repository;

import java.util.List;

public interface LocalRepository<K, V> {
    List<V> findAll();
    V findById(K id);
    void create(V... entity);
    void update(V... entity);
    void delete(V... entity);
}
