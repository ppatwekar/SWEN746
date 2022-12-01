package com.example.sam2023.controller;

import org.apache.commons.logging.Log;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.example.sam2023.model.Paper;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.example.sam2023.persistance.filestorageSystem.DirectoryEnum;
import com.example.sam2023.persistance.filestorageSystem.FileStorage;
import com.example.sam2023.persistance.filestorageSystem.UploadFileResponse;
import com.example.sam2023.service.PaperService;
import com.example.sam2023.service.SubmittorService;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class SubmittorController {
    private static final Logger LOG = Logger.getLogger(SubmittorController.class.getName());
    private SubmittorDAO submittorDAO;
    private SubmittorService submittorService;
    private PaperService paperService;
    private PaperDAO paperDAO;
    private FileStorage fileStorage;

    public SubmittorController(SubmittorDAO submittorDAO, SubmittorService submittorService, PaperService paperService,
            PaperDAO paperDAO) {
        this.submittorDAO = submittorDAO;
        this.submittorService = submittorService;
        this.paperService = paperService;
        this.paperDAO = paperDAO;
    }

    @GetMapping("submittor/{id}")
    public ResponseEntity<Submittor> getSubmittorById(@PathVariable int id) {
        // LOG.log( "GET /Submittor {0}", id);
        try {

            Submittor sub = submittorDAO.get(id);
            if (sub != null)
                return new ResponseEntity<>(sub, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("submittor/{id}/papers")
    public ResponseEntity<Paper[]> getAllPapers(@PathVariable int id) {
        // LOG.log( "GET /Submittor {0}", id);
        try {

            Paper[] papers = submittorService.getAllPapers(id);
            if (papers != null)
                return new ResponseEntity<>(papers, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("submittor/addPaperInfo")
    public ResponseEntity<Paper> addPaperInfo(@RequestBody Paper paper) {
        // LOG.log( "GET /Submittor {0}", id);
        try {

            Paper paperInner = paperDAO.create(paper);// maybe do in paper service
            boolean submittorUpdated=submittorService.addPaperSubmission(paperInner.getSubmittorId(), paperInner.getId());

            if (paperInner != null && submittorUpdated)
                return new ResponseEntity<>(paperInner, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("submittor/{id}/addPaperFile")
    public UploadFileResponse addPaperFile(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        // LOG.log( "GET /Submittor {0}", id);
        try {

            submittorService.addPaperFile(id, file);

            // if (submittorService.addPaperFile( file))
                return new  UploadFileResponse(file.getOriginalFilename(),
                file.getContentType(), file.getSize());
            // else
                // return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return null;

            // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> downloadPaper(@PathVariable int id){
        try{
            Resource file = this.paperService.getPhysicalPaper(id, DirectoryEnum.SUBMITTOR_PAPERS);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "file: "+file.getFilename()).body(file);
        }catch(IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("submittor/updatePaper")
    public ResponseEntity<Paper> updatePaper(@RequestBody Paper paper) {
        // LOG.log( "GET /Submittor {0}", id);
        try {

            if (submittorService.checkIfSubmittorHasPaper(paper.getId(),paper.getSubmittorId())  ) {
                Paper paperInner = paperDAO.update(paper);// maybe do in paper service
                if (paperInner != null)
                    return new ResponseEntity<>(paperInner, HttpStatus.CREATED);
                else
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);

            }

        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
