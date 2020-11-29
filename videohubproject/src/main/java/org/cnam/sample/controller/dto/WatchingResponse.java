package org.cnam.sample.controller.dto;

import java.util.Date;

//Viewing response + Video
public class WatchingResponse {

    public Long id;
    public Long userId;
    public Long videoId;
    public Date date;
    public String title;
    public String link;
    public Long category_id;

    public WatchingResponse(Long id, Long userId, Long videoId, Date date, String title, String link, Long category_id) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.date = date;
        this.title = title;
        this.link = link;
        this.category_id = category_id;
    }
}
