package com.example.sam2023.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Submittor extends AbstractUser{
    // private static final Logger LOG = Logger.getLogger(Product.class.getName());
    
    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;



    
}
