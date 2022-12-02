package com.example.sam2023.model;

import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paper extends AbstractIdFile{
    private Collection<Integer> reviewIds;
    private int submittorId;
    private String name;



    public Paper(@JsonProperty("id")int id, @JsonProperty("reviewIds") Collection<Integer> reviewIds,@JsonProperty("submittorId")  int submittorId, @JsonProperty("name")  String name) {
        super(id);
        this.reviewIds = reviewIds;
        this.submittorId = submittorId;
        this.name=name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Integer> getReviewIds() {
        return reviewIds;
    }
    public void setReviewIds(Collection<Integer> reviewIds) {
        this.reviewIds = reviewIds;
    }
    public int getSubmittorId() {
        return submittorId;
    }
    public void setSubmittorId(int submittorId) {
        this.submittorId = submittorId;
    }



}
