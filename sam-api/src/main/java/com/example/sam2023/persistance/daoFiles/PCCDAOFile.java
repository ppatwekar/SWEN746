package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.PCC;
import com.example.sam2023.persistance.dao.PCCDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PCCDAOFile extends AbstractUserDAOFile<PCC> implements PCCDAO{

    public PCCDAOFile(ObjectMapper objectMapper, @Value("${pcc.file}") String filename) {
        super(objectMapper, filename);
        //TODO Auto-generated constructor stub
    }
    
}
