package com.example.sam2023.controller;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.daoFiles.PaperDAOFile;
import com.example.sam2023.service.PCCService;
import com.example.sam2023.service.PCMService;
import com.example.sam2023.service.PaperService;
import com.example.sam2023.service.SubmittorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class PCCController {
    private static final Logger LOG = Logger.getLogger(PCCController.class.getName());

    private PCCService pccService;
    private PCMService pcmservice;
    private PaperDAO paperDAO;

    private PaperService paperService;

    // @GetMapping("allPapers")
    // public ResponseEntity<Paper[]> getAllPapers() {
        
    //     try {
    //         Paper[] papers = paperService.getAllPapers();
    //         if (papers != null)
    //             return new ResponseEntity<>(papers, HttpStatus.OK);
    //         else
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    //     } catch (Exception ex) {
    //         LOG.log(Level.SEVERE, ex.getLocalizedMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @PostMapping("pcc/assignPaper")
    // public ResponseEntity<Integer> assignPaper(@RequestBody int paperId, @RequestBody int pcmId) {
    //     try {
    //         // Collection<Integer> preferences = pcmservice.getRequestedPaper(pcmId); //get PCM preferences

    //         //Paper paperInner = paperDAO.create(paper);// maybe do in paper service
    //         //boolean submittorUpdated=submittorService.addPaperSubmission(paperInner.getSubmittorId(), paperInner.getId(), null);

    //         // if (paperInner != null && submittorUpdated)
    //         //     return new ResponseEntity<>(paperInner, HttpStatus.CREATED);
    //         // else
    //         //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    //     }
    //     catch(Exception e){
    //         LOG.log(Level.SEVERE, e.getLocalizedMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    //     return null;
    // }

    // @PostMapping("pcc/setRating")
    // public ResponseEntity<Integer> setRating(@RequestBody int reviewId) {
    //     try {
            
    //         //TO DO: set ratings to reviews.

    //     }
    //     catch(Exception e){
    //         LOG.log(Level.SEVERE, e.getLocalizedMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    //     return null;
    // }

    // @PostMapping("pcc/setRating")
    // public ResponseEntity<Integer> generateReport(@RequestBody int reviewId) {
    //     try {
            
    //         //TO DO: add report to reports.json.
    //     }
    //     catch(Exception e){
    //         LOG.log(Level.SEVERE, e.getLocalizedMessage());
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    //     return null;
    // }
}
