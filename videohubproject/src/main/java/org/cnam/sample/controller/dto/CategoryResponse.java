package org.cnam.sample.controller.dto;

public class CategoryResponse {

    public long id;

    public String label;


    public CategoryResponse(long id, String label) {
        this.id = id;
        this.label = label;
    }
}
