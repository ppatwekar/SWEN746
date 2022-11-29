package com.example.sam2023.persistance.daoFiles;


import com.example.sam2023.model.Admin;
import com.example.sam2023.persistance.dao.AdminDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminDAOFile extends AbstractUserDAOFile<Admin> implements AdminDAO{

    public AdminDAOFile(ObjectMapper objectMapper, @Value("${admin.file}")String filename) {
        super(objectMapper, filename);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Admin[] readFile() throws StreamReadException, DatabindException, IOException{
        Admin[] data = this.objectMapper.readValue(new File(this.filename), Admin[].class);
        return data;
    }
    
}
