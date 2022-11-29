package com.example.sam2023.controller;

import org.apache.commons.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.example.sam2023.model.Submittor;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import com.example.sam2023.service.SubmittorService;

import java.io.IOException;


@RestController
@RequestMapping("/")
public class SubmittorController {
    private static final Logger LOG = Logger.getLogger(SubmittorController.class.getName());
    private SubmittorDAO sDAO;
    private SubmittorService subService;

    public SubmittorController(SubmittorDAO sDAO, SubmittorService subService) {
        this.sDAO = sDAO;
        this.subService = subService;
    }

    @GetMapping("subs/{id}")
    public ResponseEntity<Submittor> getProduct( @PathVariable int id) {
        // LOG.log( "GET /Submittor {0}", id);
        try {

            Submittor sub = sDAO.get(id);
            if (sub != null)
                return new ResponseEntity<>(sub, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
