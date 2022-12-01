package com.example.sam2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message extends AbstractIdFile{
    public Message(@JsonProperty("id") int id){
        super(id);
    }
    // @JsonProperty("text") private String text;
    // public Message(@JsonProperty("text") String text){
    //     this.text = text;
    // }
}
