package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Report;
import com.example.sam2023.persistance.dao.ReportDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportDAOFile extends AbstractDAOFile<Report> implements ReportDAO{
    public ReportDAOFile(ObjectMapper objectMapper, @Value("${report.file}") String filename){
        super(objectMapper, filename);
    }
}
