package com.example.sam2023.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sam2023.model.Admin;
import com.example.sam2023.model.UserCredential;
import com.example.sam2023.persistance.dao.AdminDAO;
import com.example.sam2023.service.AdminService;

@RestController
@RequestMapping("admin")
public class AdminController {
    private AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Admin> authenticate(@RequestBody UserCredential u){
        Admin admin = (Admin)this.adminService.authenticateUser(u);
        if(admin != null){
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
