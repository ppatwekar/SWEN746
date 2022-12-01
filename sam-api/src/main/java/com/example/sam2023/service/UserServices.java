package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;


public interface UserServices<T> {
    void receiveNotification(int id, Message message);
    boolean authenticateUser(UserCredential u); //
}
