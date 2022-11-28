package com.example.sam2023.model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Submittor extends AbstractUser{
    private static final Logger LOG = Logger.getLogger(Submittor.class.getName());
    
    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("papersSubmitted") private Collection<Integer> papersSubmitted;
    public int getId() {
        return id;
    }
    public Submittor(int id, String name, Collection<Integer> papersSubmitted) {
        this.id = id;
        this.name = name;
        this.papersSubmitted = new LinkedList<Integer>();
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Collection<Integer> getPapersSubmitted() {
        return papersSubmitted;
    }
    public void setPapersSubmitted(Collection<Integer> papersSubmitted) {
        this.papersSubmitted = papersSubmitted;
    }



    
}
