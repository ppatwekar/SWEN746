package com.example.sam2023.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sam2023.model.PCM;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.service.PCMService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("pcm")
public class PCMController {
    private PCMService pcmService;
    public PCMController(PCMService pcmService){
        this.pcmService = pcmService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<PCM> authenticate(@RequestBody UserCredential u){
        PCM response = (PCM)this.pcmService.authenticateUser(u);
        if(response != null){
            return new ResponseEntity<PCM>(response, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
