package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.Paper;
import com.example.sam2023.persistance.dao.PaperDAO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaperDAOFile extends AbstractDAOFile<Paper> implements PaperDAO{
    public PaperDAOFile(ObjectMapper objectMapper, @Value("${paper.file}") String filename){
        super(objectMapper, filename);
    }

    @Override
    protected Paper[] readFile() throws StreamReadException, DatabindException, IOException{
        Paper[] data = this.objectMapper.readValue(new File(this.filename), Paper[].class);
        return data;
    }

    @Override
    public Paper[] getAllSubmittorPapers(int id) {
        Collection<Paper> papers=getAll();
        Collection<Paper> list = new ArrayList<Paper>();
        for (Paper paper : papers) {
            if(id == paper.getSubmittorId()){
                list.add(paper);
            }
        }
        return  list.toArray(new Paper[list.size()] );
    }

    @Override
    public Paper[] getPapersById(int id) {
        Collection<Paper> papers=getAll();
        Collection<Paper> list = new ArrayList<Paper>();
        for (Paper paper : papers) {
            if(id == paper.getId()){
                list.add(paper);
            }
        }
        return  list.toArray(new Paper[list.size()] );
    }

    @Override
    public Paper[] getAllPapers() {
        Collection<Paper> papers=getAll();
        Collection<Paper> list = new ArrayList<Paper>();
        for (Paper paper : papers) {
            list.add(paper);
        }
        return  list.toArray(new Paper[list.size()] );
    }
}
