package com.example.sam2023.service;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.filestorageSystem.DirectoryEnum;
import com.example.sam2023.persistance.filestorageSystem.FileStorage;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.core.io.Resource;
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
        return this.paperDAO.get(paperId);
    }
    
    public boolean updatePaper(Paper paper){
        return false;
    }
    public Paper[] getAllSubmittorPapers( int id){
        Paper[] allPapers = paperDAO.getAllSubmittorPapers(id);
        return allPapers;
    }

    public void storePhysicalPaper(int id, DirectoryEnum en, MultipartFile file) throws IOException{
        String path = DirectoryEnum.makePaperFolderPath(en, id);
        if(this.fileStorage.dirExists(path)){
            this.fileStorage.clearDirectory(path);
        }
        else{
            this.fileStorage.makeDir(path);  
        }

        this.fileStorage.store(file, path);
        this.fileStorage.makeDir(path+"/Reviews");
    }

    public Resource getPhysicalPaper(int id, DirectoryEnum en) throws IOException{
        String path = DirectoryEnum.makePaperFolderPath(en, id);
        return this.fileStorage.getFile(path, "Reviews");
    }


}
