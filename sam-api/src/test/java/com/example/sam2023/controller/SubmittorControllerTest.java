package com.example.sam2023.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.example.sam2023.persistance.daoFiles.AbstractUserDAOFile;
import com.example.sam2023.persistance.daoFiles.PaperDAOFile;
import com.example.sam2023.persistance.daoFiles.SubmittorDAOFile;
import com.example.sam2023.persistance.filestorageSystem.UploadFileResponse;
import com.example.sam2023.service.PaperService;
import com.example.sam2023.service.SubmittorService;

public class SubmittorControllerTest {
    private SubmittorDAO submittorDAO;
    private SubmittorService submittorService;
    private PaperService paperService;
    private PaperDAO paperDAO;
    private SubmittorController submittorController;
    private SubmittorDAOFile submittorDAOFile;
    @BeforeEach
    void init(){
        this.submittorDAO = mock(SubmittorDAOFile.class);
        this.submittorService = mock(SubmittorService.class);
        this.paperService = mock(PaperService.class);
        this.paperDAO = mock(PaperDAOFile.class);
        this.submittorController = new SubmittorController(submittorDAO, submittorService, paperService, paperDAO);
        this.submittorDAOFile = mock(SubmittorDAOFile.class);
    }

    @Test
    void testUpdatePaper() throws IOException{
        Paper paper = new Paper(0, new ArrayList(), 0, "name");

        when(this.submittorService.checkIfSubmittorHasPaper(0, 0)).thenReturn(true);
        when(this.paperDAO.update(paper)).thenReturn(paper);

        ResponseEntity<Paper> resp = this.submittorController.updatePaper(paper);

        assertEquals(resp.getBody(), paper);
    }

    @Test
    void testAuthenticate(){
        UserCredential u = new UserCredential("email@email.com", "password");

        Submittor submittor = new Submittor(0, "name", new ArrayList<>(), "email@email.com", "password");
        when(this.submittorDAO.authenticateUser(u)).thenReturn(submittor);

        ResponseEntity<Submittor> resp = this.submittorController.authenticate(u);

        assertEquals(submittor, resp.getBody());
    }

    @Test
    void testGetAllPapers(){
        Paper[] papers = {
            new Paper(0, new ArrayList<>(), 0, "name")
        };

        when(this.submittorService.getAllPapers(69)).thenReturn(papers);

        ResponseEntity<Paper[]> resp = this.submittorController.getAllPapers(69);

        assertEquals(papers[0], resp.getBody()[0]);
    }

    @Test
    void testAddPaperInfo() throws IOException{
        Paper paper = new Paper(0, new ArrayList<>(), 0, "name");
        when(this.paperDAO.create(paper)).thenReturn(paper);
        when(this.submittorService.addPaperSubmission(0, 0)).thenReturn(true);

        ResponseEntity<Paper> resp = this.submittorController.addPaperInfo(paper);
        assertEquals(paper, resp.getBody());
    }   

    @Test
    void getSubmittorByIdTest(){
        int id = 5;
        Submittor submittor = new Submittor(id, "", new ArrayList<>(), "", "");
        when(this.submittorDAO.get(id)).thenReturn(submittor);

        ResponseEntity<Submittor> resp = this.submittorController.getSubmittorById(id);

        assertEquals(submittor, resp.getBody());
    }

    @Test
    void testAddPaperFile(){
        MultipartFile file = new MultipartFile() {

            @Override
            public String getName() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getOriginalFilename() {
                // TODO Auto-generated method stub
                return "name";
            }

            @Override
            public String getContentType() {
                // TODO Auto-generated method stub
                return "pdf";
            }

            @Override
            public boolean isEmpty() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public long getSize() {
                // TODO Auto-generated method stub
                return 500;
            }

            @Override
            public byte[] getBytes() throws IOException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public InputStream getInputStream() throws IOException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {
                // TODO Auto-generated method stub
            }
            
        };

        int id = 6;

        when(this.submittorService.addPaperFile(id, file)).thenReturn(true);

        UploadFileResponse response = this.submittorController.addPaperFile(id, file);

    }
}
