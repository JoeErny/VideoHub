package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewingRequest {

    public Long userId;
    public Long videoId;

    @JsonCreator
    public ViewingRequest(@JsonProperty("user_id") Long userId, @JsonProperty("video_id") Long videoId) {
        this.userId = userId;
        this.videoId = videoId;
    }
}
