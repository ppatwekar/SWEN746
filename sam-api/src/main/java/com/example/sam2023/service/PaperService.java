package com.example.sam2023.service;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.filestorageSystem.DirectoryEnum;
import com.example.sam2023.persistance.filestorageSystem.FileStorage;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.codec.ClientCodecConfigurer.MultipartCodecs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PaperService {
    private PaperDAO paperDAO;
    private FileStorage fileStorage;

    public PaperService(PaperDAO paperDAO, FileStorage fileStorage) {
        this.paperDAO = paperDAO;
        this.fileStorage = fileStorage;
    }
    public void addReview(int pcmId,int  paperId,String review ){
        
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
    public Paper[] getAllSubmittorPapers( int id){
        Paper[] allPapers = paperDAO.getAllSubmittorPapers(id);
        return allPapers;
    }

    public void storeSubmittorPaper(MultipartFile file, int submittorId) throws IOException{
        String path = DirectoryEnum.makePaperFolderPath(DirectoryEnum.SUBMITTOR_PAPERS, submittorId);
        if(this.fileStorage.dirExists(path)){
            this.fileStorage.clearDirectory(path);
        }
        else{
            this.fileStorage.makeDir(path);  
        }

        this.fileStorage.store(file, path);
    }


}
