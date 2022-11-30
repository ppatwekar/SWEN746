package com.example.sam2023.persistance.filestorageSystem;

public enum DirectoryEnum {
    
    PAPERS("sam-api/src/data/files/papers"),
    SUBMITTOR_PAPERS(PAPERS.getPath()+"/submittor_papers"),
    PCM_PAPERS(PAPERS.getPath()+"/pcm_papers")
    ;
    private String path;
    private DirectoryEnum(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public static String makePaperFolderPath(DirectoryEnum en ,int id){
        return en.getPath()+"/Paper_"+id;
    }
}
