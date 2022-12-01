package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.PCCDAO;
import org.springframework.stereotype.Service;

@Service
public class PCCService extends AbstractUserServices<PCCDAO>{
    public PCCService(PCCDAO pccdao){
        super(pccdao);
    }

    @Override
    public void receiveNotification(int id, Message message) {
        // TODO Auto-generated method stub
        
    }

    public boolean setRatings(int reviewId) {
        // TODO

        return false;
    }

    public boolean getRating(int ratingId) {
        // TODO

        return false;
    }

    //Common feature
    public boolean getTemplate(int templateType) {
        // TODO

        return false;
    }

    public boolean generateReport(int ratingId, int templateId) {
        // TODO

        return false;
    }
    
}
