package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.Paper;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SubmittorService implements UserServices{
    private SubmittorDAO submittorDAO;
    private PaperService paperService;

    public SubmittorService(SubmittorDAO submittorDAO, PaperService paperService) {
        this.submittorDAO = submittorDAO;
        this.paperService = paperService;
    }


    public SubmittorDAO getSubmittorDAO() {
        return submittorDAO;
    }


    public void setSubmittorDAO(SubmittorDAO submittorDAO) {
        this.submittorDAO = submittorDAO;
    }


    public PaperService getPaperService() {
        return paperService;
    }


    public void setPaperService(PaperService paperService) {
        this.paperService = paperService;
    }


    

    @Override
    public void receiveNotification(int id, Message message) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean authenticateUser(UserCredential u) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean addPaperSubmission(int submittorId, MultipartFile file) {
        // TODO Auto-generated method stub
        return false;
    }

    public Paper[] getAllPapers() {
        Paper[] p1=paperService.getAllPapers();
        return p1;
    }

    public boolean updatePaper(int paperID) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
