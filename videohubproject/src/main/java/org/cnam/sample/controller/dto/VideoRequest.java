package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoRequest {

    public String title;
    public String link;
    public Long category_id;

    //test commentaire

    @JsonCreator
    public VideoRequest(@JsonProperty("title") String title,@JsonProperty("link") String link, @JsonProperty("category_id") Long category_id) {
        this.title = title;
        this.link = link;
        this.category_id =category_id;
    }

}

