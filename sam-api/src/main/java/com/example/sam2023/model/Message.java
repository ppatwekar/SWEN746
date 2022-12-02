package com.example.sam2023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message extends AbstractIdFile{
    @JsonProperty("text") private String text;
    @JsonProperty("isoStringTimestamp") String isoStringTimestamp;
    public Message(@JsonProperty("id") int id, @JsonProperty("text") String text, @JsonProperty("timestamp") String isoStringTimestamp){
        super(id);
        this.text = text;
        this.isoStringTimestamp = isoStringTimestamp;
    }
    // @JsonProperty("text") private String text;
    // public Message(@JsonProperty("text") String text){
    //     this.text = text;
    // }
}
