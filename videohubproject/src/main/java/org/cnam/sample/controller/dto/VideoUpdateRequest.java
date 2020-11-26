package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoUpdateRequest {

    public long id;
    public String title;
    public String link;
    public Long category_id;

    @JsonCreator
    public VideoUpdateRequest(@JsonProperty("id") Long id,@JsonProperty("title") String title, @JsonProperty("link") String link, @JsonProperty("category_id") Long category_id) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category_id =category_id;
    }
}
