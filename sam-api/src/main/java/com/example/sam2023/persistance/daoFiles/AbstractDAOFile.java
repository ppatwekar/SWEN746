package com.example.sam2023.persistance.daoFiles;

import java.util.Collection;
import java.util.Map;

import com.example.sam2023.persistance.dao.DAO;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractDAOFile<T> implements DAO<T>{
    protected ObjectMapper objectMapper;
    protected String filename;
    protected Map<Integer, T> map; 

    @Override
    public T get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(T obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T update(T obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T create(T obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<T> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }
    
}
