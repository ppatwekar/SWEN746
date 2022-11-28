package com.example.sam2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paper extends AbstractIdFile{
    public Paper(@JsonProperty("id") int id){
        super(id);
    }
}
