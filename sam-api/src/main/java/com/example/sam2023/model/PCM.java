package com.example.sam2023.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PCM extends AbstractUser{
    @JsonProperty("paperPreferences") private Collection<Integer> pcmPaperPreferences;

    public PCM(@JsonProperty("id") int id, @JsonProperty("email") String email, 
    @JsonProperty("password") String password, 
    @JsonProperty("paperPreferences") Collection<Integer> pcmPaperPreferences){
        super(id, email, password);
        this.pcmPaperPreferences = pcmPaperPreferences;
    }
}
