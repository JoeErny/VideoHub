package org.cnam.sample.controller.dto;

import org.cnam.sample.domain.entity.Video;

import java.util.List;

public class BrowsingResponse {

public List<Video> videos_found;

    public BrowsingResponse(List<Video> videos) {
        this.videos_found = videos;
    }

}
