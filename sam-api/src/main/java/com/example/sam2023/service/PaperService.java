package com.example.sam2023.service;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;

import java.util.Collection;
import java.util.Map;

import org.springframework.http.codec.ClientCodecConfigurer.MultipartCodecs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PaperService {
    private PaperDAO paperDAO;

    public void  addReview(int pcmId,int  paperId,String review ){
        
    };
    public Map<Integer, String> getPartialPaperInformation(Collection<Integer> paperIds){
        return null;
    }
    public Paper getPaperById(int paperId){
        return null;
    }
    public boolean createNewPaper(int submittorId,MultipartFile file){
        return false;
    }
    public boolean updatePaper(int paperID){
        return false;
    }
    public Paper[]getAllPapers( ){
        return null;
    }


}
