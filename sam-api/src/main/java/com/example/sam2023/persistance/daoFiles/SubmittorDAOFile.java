package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SubmittorDAOFile extends AbstractUserDAOFile<Submittor> implements SubmittorDAO{
    public SubmittorDAOFile(ObjectMapper objectMapper, String filename){
        super(objectMapper, filename);
    }


}
