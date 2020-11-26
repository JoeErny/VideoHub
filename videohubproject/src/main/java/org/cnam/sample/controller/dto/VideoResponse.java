package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoResponse {

    public long id;

    public String title;
    public String link;
    public Long category_id;

    public VideoResponse(long id, String title, String link, Long category_id) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category_id = category_id;
    }
}
