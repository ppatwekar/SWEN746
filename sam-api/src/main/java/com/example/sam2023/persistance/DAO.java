package com.example.sam2023.persistance;

import java.util.Collection;

public interface DAO<T> {
    T get(int id);
    void save(T obj);
    T update(T obj);
    T create(T obj);
    Collection<T> getAll();
    void deleteAll();
}
