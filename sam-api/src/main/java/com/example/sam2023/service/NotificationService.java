package com.example.sam2023.service;

import com.example.sam2023.persistance.dao.AdminDAO;
import com.example.sam2023.persistance.dao.PCCDAO;
import com.example.sam2023.persistance.dao.PCMDAO;
import com.example.sam2023.persistance.dao.SubmittorDAO;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private AdminDAO adminDAO;
    private PCMDAO pcmdao;
    private PCCDAO pccdao;
    private SubmittorDAO submittorDAO;
}
