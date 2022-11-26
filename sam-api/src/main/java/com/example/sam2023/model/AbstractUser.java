package com.example.sam2023.model;

import java.util.Collection;

public abstract class AbstractUser implements UserNotifications {
    protected Collection<Message> notifications;
    private int id;

    @Override
    public void receiveNotification(Message message) {
        // TODO Auto-generated method stub
        
    }
}
