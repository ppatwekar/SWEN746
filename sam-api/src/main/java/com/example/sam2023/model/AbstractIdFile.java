package com.example.sam2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractIdFile {
    @JsonProperty("id") private int id;

    public AbstractIdFile(@JsonProperty("id") int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
    
    public void setID(int id){
        this.id = id;
    }
}
