package com.example.sam2023.persistance.daoFiles;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.sam2023.model.AbstractIdFile;
import com.example.sam2023.persistance.dao.DAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractDAOFile<T extends AbstractIdFile> implements DAO<T>{
    protected ObjectMapper objectMapper;
    protected String filename;
    protected Map<Integer, T> map; 
    private static int nextId;

    public AbstractDAOFile(ObjectMapper objectMapper, String filename) {
        this.objectMapper = objectMapper;
        this.filename = "filename";
        this.map = new HashMap<>();
        try{
            this.load();
        }catch(Exception e){
            System.out.println("Error in loading "+this.filename);
        }
    }

    @Override
    public T get(int id) {
        synchronized(this.map){
            return this.map.get(id);
        }
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

    private boolean load() throws StreamReadException, DatabindException, IOException{
        this.map = new HashMap<>();

        Object[] objs = this.objectMapper.readValue(new File(this.filename), Object[].class);
        AbstractDAOFile.nextId = 0;


        for(Object o : objs){
            T obj = (T)o;
            this.map.put(obj.getId(), obj);
            if(obj.getId() > AbstractDAOFile.nextId){
                AbstractDAOFile.nextId = obj.getId(); //hmm nvm
            }
        }

        ++AbstractDAOFile.nextId;
        return true;
    }
    
}
