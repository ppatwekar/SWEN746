package com.example.sam2023.model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Submittor extends AbstractUser{
    private static final Logger LOG = Logger.getLogger(Submittor.class.getName());
    
    //@JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("papersSubmitted") private Collection<Integer> papersSubmitted;
    
    public Submittor(@JsonProperty("id") int id, @JsonProperty("name") String name, 
    @JsonProperty("papersSubmitted") Collection<Integer> papersSubmitted, @JsonProperty("email") String email, @JsonProperty("password") String password) {
        super(id, email, password);
        //this.id = id;
        this.name = name;
        this.papersSubmitted = papersSubmitted;
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

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Submittor)){
            return false;
        }

        Submittor s = (Submittor)o;

        return s.getEmail().equals(this.getEmail())
        && s.getId() == this.getId()
        && s.getName().equals(this.getName())
        && s.getPassword().equals(this.getPassword())
        && s.getPapersSubmitted().equals(this.getPapersSubmitted());
    }

    
}
