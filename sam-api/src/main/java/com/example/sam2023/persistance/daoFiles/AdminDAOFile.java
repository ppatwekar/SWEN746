package com.example.sam2023.persistance.daoFiles;


import com.example.sam2023.model.Admin;
import com.example.sam2023.persistance.dao.AdminDAO;
import org.springframework.stereotype.Component;

@Component
public class AdminDAOFile extends AbstractUserDAOFile<Admin> implements AdminDAO{
    
}
