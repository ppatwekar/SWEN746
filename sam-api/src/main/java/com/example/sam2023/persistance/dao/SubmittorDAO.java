package com.example.sam2023.persistance.dao;

import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;

public interface SubmittorDAO extends DAO<Submittor>{
    
    public boolean addPaperSubmission(int submittorId , MultipartFile file);
    public Paper[] getAllPapers( );

    
// +updatePaper( paperID: Integer):Boolean
// +createNewSubmittor(Submittor u):Boolean
    
}
