package com.example.sam2023.persistance.daoFiles;


import com.example.sam2023.model.Admin;
import com.example.sam2023.persistance.dao.AdminDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class AdminDAOFile extends AbstractUserDAOFile<Admin> implements AdminDAO{

    public AdminDAOFile(ObjectMapper objectMapper, String filename) {
        super(objectMapper, filename);
        //TODO Auto-generated constructor stub
    }
    
}
