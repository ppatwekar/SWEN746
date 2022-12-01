package com.example.sam2023.persistance.daoFiles;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import com.example.sam2023.persistance.dao.DAO;
import com.example.sam2023.persistance.dao.MessageDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.sam2023.model.Message;

public class MessageDAOFile extends AbstractDAOFile<Message> implements MessageDAO {

    public MessageDAOFile(ObjectMapper objectMapper, @Value("${messages.file}") String filename){
        super(null, filename);
    }

    @Override
    protected Message[] readFile() throws StreamReadException, DatabindException, IOException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
