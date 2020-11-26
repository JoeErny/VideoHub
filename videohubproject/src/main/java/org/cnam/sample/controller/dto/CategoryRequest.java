package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {

    public String label;

    @JsonCreator
    public CategoryRequest(@JsonProperty("label") String label) {
        this.label = label;
    }
}
