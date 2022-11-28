package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaperDAOFile extends AbstractDAOFile<Paper> implements PaperDAO{
    public PaperDAOFile(ObjectMapper objectMapper, @Value("${paper.file}") String filename){
        super(objectMapper, filename);
    }
}
