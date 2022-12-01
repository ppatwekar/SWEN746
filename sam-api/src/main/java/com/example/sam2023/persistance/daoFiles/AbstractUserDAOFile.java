package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.AbstractUser;
import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.UserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractUserDAOFile<T extends AbstractUser> extends AbstractDAOFile<T> implements UserDAO<T>{
    public AbstractUserDAOFile(ObjectMapper objectMapper, String filename) {
        super(objectMapper, filename);
    }

    @Override
    public T authenticateUser(UserCredential u){
        for(T user : this.map.values()){
            if(user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())){
                return user;
            }
        }
        return null;
    }

    // @Override
    // public void receiveNotification(int id, Message message) {
    //     T user = this.get(id);
    //     user.receiveNotification(message);
    // }

    
}
