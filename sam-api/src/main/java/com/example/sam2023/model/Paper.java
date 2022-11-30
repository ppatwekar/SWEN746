package com.example.sam2023.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paper extends AbstractIdFile{
    private Collection<Integer> reviewIds;
    private int submittorId;
    public Paper(@JsonProperty("id") int id, @JsonProperty("reviewIds") Collection<Integer> reviewIds,  @JsonProperty("submittorId") int submittorId) {
        super(id);
        this.reviewIds = reviewIds;
        this.submittorId = submittorId;
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
