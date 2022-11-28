package com.example.sam2023.persistance.dao;

import java.io.IOException;
import java.util.Collection;

public interface DAO<T> {
    T get(int id);
    void save() throws IOException;
    T update(T obj) throws IOException;
    T create(T obj) throws IOException;
    Collection<T> getAll();
    void deleteAll();
}
