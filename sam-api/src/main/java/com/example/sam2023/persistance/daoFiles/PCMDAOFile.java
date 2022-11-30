package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.PCM;
import com.example.sam2023.persistance.dao.PCMDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PCMDAOFile extends AbstractUserDAOFile<PCM> implements PCMDAO{

    public PCMDAOFile(ObjectMapper objectMapper, @Value("${pcm.file}") String filename) {
        super(objectMapper, filename);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected PCM[] readFile() throws StreamReadException, DatabindException, IOException{
        PCM[] data = this.objectMapper.readValue(new File(this.filename), PCM[].class);
        return data;
    }

    public Collection<Integer> getRequestedPaper(int pcmId){
        //Add requested papers to PCM class
        return null;
    }
    
}
