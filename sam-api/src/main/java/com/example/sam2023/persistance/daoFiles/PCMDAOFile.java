package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.PCM;
import com.example.sam2023.persistance.dao.PCMDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PCMDAOFile extends AbstractUserDAOFile<PCM> implements PCMDAO{

    public PCMDAOFile(ObjectMapper objectMapper, @Value("${pcm.file}") String filename) {
        super(objectMapper, filename);
        //TODO Auto-generated constructor stub
    }
    
}
