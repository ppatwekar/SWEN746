package com.example.sam2023.controller;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.daoFiles.PaperDAOFile;
import com.example.sam2023.service.PCCService;
import com.example.sam2023.service.PaperService;
import com.example.sam2023.service.SubmittorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class PCCController {
    private static final Logger LOG = Logger.getLogger(PCCController.class.getName());

    private PCCService pccService;
    private PaperDAO paperDAO;

    private PaperService paperService;

    @GetMapping("allPapers/{id}")
    public ResponseEntity<List<Paper>> getAllPapers(@PathVariable int id) {
        // LOG.log( "GET /AllPapers {0}", id);
        try {
            List<Paper> papers = (List<Paper>) paperDAO.getAll();
            if (papers != null && papers.size()>0)
                return new ResponseEntity<List<Paper>>(papers, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
