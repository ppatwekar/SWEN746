package com.example.sam2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCredential {
    @JsonProperty("email") private String email;
    @JsonProperty("password") private String password;

    public UserCredential(@JsonProperty("email") String email, @JsonProperty("password") String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
}
