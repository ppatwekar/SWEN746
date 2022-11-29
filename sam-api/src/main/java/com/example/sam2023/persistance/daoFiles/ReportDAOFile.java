package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Report;
import com.example.sam2023.persistance.dao.ReportDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportDAOFile extends AbstractDAOFile<Report> implements ReportDAO{
    public ReportDAOFile(ObjectMapper objectMapper, @Value("${report.file}") String filename){
        super(objectMapper, filename);
    }

    @Override
    protected Report[] readFile() throws StreamReadException, DatabindException, IOException{
        Report[] data = this.objectMapper.readValue(new File(this.filename), Report[].class);
        return data;
    }
}
