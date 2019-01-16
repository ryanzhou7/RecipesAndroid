package com.example.ryanzhouold.bakingandroid.data.repository;

import java.util.List;

public interface LocalRepository<K, V> {
    List<V> findAll();
    V findById(K id);
    V create(V... entity);
    V update(V... entity);
    void delete(V... entity);
}
