package com.example.sam2023.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.example.sam2023.persistance.daoFiles.AbstractUserDAOFile;
import com.example.sam2023.persistance.daoFiles.PaperDAOFile;
import com.example.sam2023.persistance.daoFiles.SubmittorDAOFile;
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
}
