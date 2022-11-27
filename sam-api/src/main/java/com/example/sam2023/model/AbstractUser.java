package com.example.sam2023.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractUser implements UserNotifications {
    protected Collection<Message> notifications;
    @JsonProperty("id") private int id;
    @JsonProperty("email") private String email;
    @JsonProperty("password") private String password;

    @Override
    public void receiveNotification(Message message) {
        // TODO Auto-generated method stub
        
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
}
