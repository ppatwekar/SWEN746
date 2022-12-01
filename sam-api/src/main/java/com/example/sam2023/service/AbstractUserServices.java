package com.example.sam2023.service;

import com.example.sam2023.model.AbstractUser;
import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.UserDAO;

public abstract class AbstractUserServices<T extends UserDAO> implements UserServices<T>{
    protected T dao;

    public AbstractUserServices(T dao){
        this.dao = dao;
    }

    @Override
    public AbstractUser authenticateUser(UserCredential u) {
        return (AbstractUser)this.dao.authenticateUser(u);
    }

    @Override
    public void receiveNotification(int id, Message message) {
        AbstractUser u = (AbstractUser)this.dao.get(id);
        u.receiveNotification(message);
    }
}
