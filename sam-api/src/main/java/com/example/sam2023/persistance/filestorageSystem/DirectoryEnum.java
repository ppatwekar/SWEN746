package com.example.sam2023.persistance.filestorageSystem;

public enum DirectoryEnum {
    
    PAPERS("sam-api/src/data/files/papers"),
    SUBMITTOR_PAPERS("sam-api/src/data/files/papers/submittor_papers"),
    PCM_PAPERS("sam-api/src/data/files/papers/pcm_papers")
    ;
    private String path;
    private DirectoryEnum(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
