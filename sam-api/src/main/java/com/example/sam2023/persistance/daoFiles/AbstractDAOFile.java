package com.example.sam2023.persistance.daoFiles;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.sam2023.model.AbstractIdFile;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.DAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractDAOFile<T extends AbstractIdFile> implements DAO<T>{
    protected ObjectMapper objectMapper;
    protected String filename;
    protected Map<Integer, T> map; 
    protected int nextId;

    public AbstractDAOFile(ObjectMapper objectMapper, String filename) {
        this.objectMapper = objectMapper;
        this.filename = filename;
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
    public void save() throws IOException{
         Collection<T> values = this.map.values();
         this.objectMapper.writeValue(new File(this.filename), values);
    }

    @Override
    public T update(T obj) throws IOException {
        synchronized(this.map){
            if(this.map.containsKey(obj.getId())){
                this.map.put(obj.getId(), obj);
                this.save();
                return obj;
            }
            return null;
        }
    }

    @Override
    public T create(T obj) throws IOException{
        synchronized(this.map){
            obj.setID(this.nextId());
            this.map.put(obj.getId(), obj);
            this.save();
            return obj;
        }
    }

    @Override
    public Collection<T> getAll() {
        synchronized(this.map){
            return this.map.values();
        }
    }

    @Override
    public void deleteAll() throws IOException {
        synchronized(this.map){
            this.map = new HashMap<>();
            this.save();
        }
    }

    @Override
    public void delete(T obj){
        synchronized(this.map){
            this.map.remove(obj.getId());
        }
    }

    @SuppressWarnings("unchecked")
    private boolean load() throws StreamReadException, DatabindException, IOException{
        this.map = new HashMap<>();

        //Collection<String> = this.objectMapper.readValue(new File(this.filename), String.class)

        //ObjectMapper and generic types.
        // Collection<T> objs = this.objectMapper.readValue(new File(this.filename), ((Class<Collection<T>>) ((ParameterizedType) getClass()
        // .getGenericSuperclass()).getActualTypeArguments()[0]));
        // this.nextId = 0;

        T[] objs = this.readFile();


        for(T obj : objs){
            this.map.put(obj.getId(), obj);
            if(obj.getId() > this.nextId){
                this.nextId = obj.getId(); //hmm nvm
            }
        }

        ++this.nextId;
        return true;
    }

    private int nextId(){
        int id = this.nextId;
        this.nextId++;
        return id;
    }

    protected abstract T[] readFile() throws StreamReadException, DatabindException, IOException;
    
}
