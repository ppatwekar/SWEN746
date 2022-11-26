package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.PCCDAO;
import org.springframework.stereotype.Service;

@Service
public class PCCService implements UserServices{
    private PCCDAO pccdao;

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
