package com.example.sam2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PCM extends AbstractUser{
    public PCM(@JsonProperty("id") int id, @JsonProperty("email") String email, @JsonProperty("password") String password){
        super(id, email, password);
    }
}
