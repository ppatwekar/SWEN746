package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.PCMDAO;

public class PCMService implements UserServices {
    private PCMDAO pcmdao;

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
