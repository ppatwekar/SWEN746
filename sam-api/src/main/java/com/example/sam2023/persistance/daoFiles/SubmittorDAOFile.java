package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SubmittorDAOFile extends AbstractUserDAOFile<Submittor> implements SubmittorDAO{
    public SubmittorDAOFile(ObjectMapper objectMapper, @Value("${submittor.file}") String filename){
        super(objectMapper, filename);
    }

    @Override
    protected Submittor[] readFile() throws StreamReadException, DatabindException, IOException{
        Submittor[] data = this.objectMapper.readValue(new File(this.filename), Submittor[].class);
        return data;
    }


}
