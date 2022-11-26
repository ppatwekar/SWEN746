package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.AdminDAO;

public class AdminService implements UserServices{
    private AdminDAO adminDAO;

    @Override
    public void receiveNotification(int id, Message message) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean authenticateUser(UserCredential u) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
