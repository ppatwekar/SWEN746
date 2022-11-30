package com.example.sam2023.persistance.dao;

import com.example.sam2023.model.Paper;

public interface PaperDAO extends DAO<Paper> {
    public Paper[]  getAllSubmittorPapers( int id);

    public Paper[] getAllPapers();

    public Paper[] getPapersById(int id);
}
