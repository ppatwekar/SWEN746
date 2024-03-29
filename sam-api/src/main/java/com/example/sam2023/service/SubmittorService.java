package com.example.sam2023.service;

import com.example.sam2023.model.Message;
import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.example.sam2023.persistance.filestorageSystem.DirectoryEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SubmittorService extends AbstractUserServices<SubmittorDAO>{
    private PaperService paperService;

    public SubmittorService(SubmittorDAO submittorDAO, PaperService paperService) {
        super(submittorDAO);
        this.paperService = paperService;
    }


    public SubmittorDAO getSubmittorDAO() {
        return dao;
    }


    public void setSubmittorDAO(SubmittorDAO submittorDAO) {
        this.dao = submittorDAO;
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


    public boolean addPaperSubmission(int submittorId, int paperId) {
        Submittor s =dao.get(submittorId);
        Collection<Integer> papersSubmitted=s.getPapersSubmitted();
        papersSubmitted.add(paperId);
        s.setPapersSubmitted(papersSubmitted);

        try {
            dao.update(s);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    public boolean addPaperFile(int id,MultipartFile file) {

        DirectoryEnum en= DirectoryEnum.SUBMITTOR_PAPERS;
        try {
            paperService.storePhysicalPaper(id, en, file);
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public Paper[] getAllPapers(int id) {
        Submittor submittor = this.dao.get(id);
        Collection<Integer> papers = submittor.getPapersSubmitted();
        Collection<Paper> lstPapers = new ArrayList<>();

        for(Integer paperId : papers){
            lstPapers.add(this.paperService.getPaperById(paperId));
        }

        Paper[] retPapers = new Paper[lstPapers.size()];
        retPapers = lstPapers.toArray(retPapers);
        return retPapers;
    }

    public boolean checkIfSubmittorHasPaper(int paperId,int submittorId) {
        // TODO Auto-generated method stub
        Submittor s =dao.get(submittorId);
        Collection<Integer> papersSubmitted=s.getPapersSubmitted();
        for (Integer id : papersSubmitted) {
            if(id==paperId)
                return true;
        }
      
            return false;
    }
    
}
