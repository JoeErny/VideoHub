package org.cnam.sample.controller.dto;

import java.util.Date;

public class ViewingResponse {

    public Long id;
    public Long userId;
    public Long videoId;
    public Date date;

    public ViewingResponse(Long id, Long userId, Long videoId, Date date) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.date = date;
    }
}
