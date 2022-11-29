package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaperDAOFile extends AbstractDAOFile<Paper> implements PaperDAO{
    public PaperDAOFile(ObjectMapper objectMapper, @Value("${paper.file}") String filename){
        super(objectMapper, filename);
    }

    @Override
    protected Paper[] readFile() throws StreamReadException, DatabindException, IOException{
        Paper[] data = this.objectMapper.readValue(new File(this.filename), Paper[].class);
        return data;
    }
}
