package com.example.sam2023.persistance.dao;

import com.example.sam2023.model.AbstractUser;
import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;

public interface UserDAO<T extends AbstractUser> extends DAO<T>{
    T authenticateUser(UserCredential u);
    //void receiveNotification(int id, Message message);
    
}
