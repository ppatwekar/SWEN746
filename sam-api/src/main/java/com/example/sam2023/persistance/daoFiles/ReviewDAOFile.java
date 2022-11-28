package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Review;
import com.example.sam2023.persistance.dao.ReviewDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReviewDAOFile extends AbstractDAOFile<Review> implements ReviewDAO {
    public ReviewDAOFile(ObjectMapper objectMapper, @Value("${review.file}") String filename){
        super(objectMapper, filename);
    }
}
