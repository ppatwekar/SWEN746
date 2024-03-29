package com.example.sam2023.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractUser extends AbstractIdFile implements UserNotifications {
    protected Collection<Message> notifications;
    //@JsonProperty("id") private int id;
    @JsonProperty("email") private String email;
    @JsonProperty("password") private String password;

    
    public AbstractUser(int id, @JsonProperty("email") String email, @JsonProperty("password") String password){
        super(id);
        this.email = email;
        this.password = password;
        this.notifications = new ArrayList<>();
    }

    // @Override
    // public void receiveNotification(Message message) {
    //     // TODO Auto-generated method stub
        
    // }

    public void receiveNotification(Message message){
        this.notifications.add(message);
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }
}
