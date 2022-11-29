package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Review;
import com.example.sam2023.persistance.dao.ReviewDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReviewDAOFile extends AbstractDAOFile<Review> implements ReviewDAO {
    public ReviewDAOFile(ObjectMapper objectMapper, @Value("${review.file}") String filename){
        super(objectMapper, filename);
    }

    @Override
    protected Review[] readFile() throws StreamReadException, DatabindException, IOException{
        Review[] data = this.objectMapper.readValue(new File(this.filename), Review[].class);
        return data;
    }
}
