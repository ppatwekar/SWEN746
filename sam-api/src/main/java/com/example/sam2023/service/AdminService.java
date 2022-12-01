package com.example.sam2023.service;


import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.AdminDAO;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends AbstractUserServices<AdminDAO>{

    public AdminService(AdminDAO adminDAO){
        super(adminDAO);
    }

    @Override
    public void receiveNotification(int id, Message message) {
        // TODO Auto-generated method stub
        
    }
    
}
