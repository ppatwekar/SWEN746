package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Review;
import com.example.sam2023.persistance.dao.ReviewDAO;
import org.springframework.stereotype.Component;

@Component
public class ReviewDAOFile extends AbstractDAOFile<Review> implements ReviewDAO {
    
}
