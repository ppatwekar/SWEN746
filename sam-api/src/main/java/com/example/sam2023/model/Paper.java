package com.example.sam2023.model;

import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paper extends AbstractIdFile{
    @JsonProperty("reviewIds") private Collection<Integer> reviewIds;
    @JsonProperty("submittorId") private int submittorId;
    @JsonProperty("name") private String name;



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

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Paper)){
            return false;
        }

        Paper p = (Paper)o;

        return p.getId() == this.getId() 
        && p.getName() == this.getName()
        && p.getSubmittorId() == this.getSubmittorId()
        && p.getReviewIds().equals(this.getReviewIds());
    }



}