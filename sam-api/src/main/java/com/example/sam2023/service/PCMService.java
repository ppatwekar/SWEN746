package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.PCMDAO;
import org.springframework.stereotype.Service;

@Service
public class PCMService extends AbstractUserServices<PCMDAO> {

    public PCMService(PCMDAO pcmdao){
        super(pcmdao);
    }



    
}
