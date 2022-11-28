package com.example.sam2023.persistance.daoFiles;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.sam2023.persistance.dao.DAO;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractDAOFile<T> implements DAO<T>{
    protected ObjectMapper objectMapper;
    protected String filename;
    protected Map<Integer, T> map; 

    public AbstractDAOFile(ObjectMapper objectMapper, String filename) {
        this.objectMapper = objectMapper;
        this.filename = "filename";
        this.map = new HashMap<>();
    }

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

    private boolean load(){
        

        // Deserializes the JSON objects from the file into an array of heroes
        // readValue will throw an IOException if there's an issue with the file
        // or reading from the file

        // Add each T to the tree map and keep track of the greatest id
        
        // Make the next id one greater than the maximum from the file
        return false;
    }
    
}
