package com.example.sam2023.service;

import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.UserDAO;

public abstract class AbstractUserServices<T extends UserDAO> implements UserServices<T>{
    protected T dao;

    public AbstractUserServices(T dao){
        this.dao = dao;
    }

    @Override
    public boolean authenticateUser(UserCredential u) {
        return this.dao.authenticateUser(u);
    }
}
