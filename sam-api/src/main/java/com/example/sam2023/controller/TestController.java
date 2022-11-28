package com.example.sam2023.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sam2023.persistance.filestorageSystem.DirectoryEnum;
import com.example.sam2023.persistance.filestorageSystem.FileStorage;

@RestController
@RequestMapping("test")
public class TestController {
    private FileStorage fileStorage;
    public TestController(FileStorage fileStorage){
        this.fileStorage = fileStorage;
    }

    @PostMapping("/")
    public ResponseEntity<String> handleUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        try {
            this.fileStorage.store(file, DirectoryEnum.SUBMITTOR_PAPERS.getPath());
            return new ResponseEntity<>("success" ,HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            // TODO Auto-generated catch block
        }
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        try {
            Resource file = this.fileStorage.loadAsResource(DirectoryEnum.SUBMITTOR_PAPERS.getPath()+"/"+filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "file: "+file.getFilename()).body(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    
}
