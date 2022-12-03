package com.example.sam2023.controller;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.dao.SubmittorDAO;
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

    @BeforeEach
    void init(){
        this.submittorDAO = mock(SubmittorDAOFile.class);
        this.submittorService = mock(SubmittorService.class);
        this.paperService = mock(PaperService.class);
        this.paperDAO = mock(PaperDAOFile.class);
        this.submittorController = new SubmittorController(submittorDAO, submittorService, paperService, paperDAO);
    }

    void testUpdatePaper(){
    }
}
