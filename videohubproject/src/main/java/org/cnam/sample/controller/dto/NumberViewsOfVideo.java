package org.cnam.sample.controller.dto;

import java.util.Date;

public class NumberViewsOfVideo {

    public Long videoId;
    public Long numberOfViews;

    public NumberViewsOfVideo(Long videoId, Long numberOfViews) {
        this.videoId = videoId;
        this.numberOfViews = numberOfViews;
    }
}
