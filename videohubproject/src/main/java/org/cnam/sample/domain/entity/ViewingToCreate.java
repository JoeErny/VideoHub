package org.cnam.sample.domain.entity;

import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.VideoModel;

import java.util.Date;

public class ViewingToCreate {
    public Long userId;
    public Long videoId;
    public Date date;

    public ViewingToCreate(Long userId, Long videoId, Date date) {
        this.userId = userId;
        this.videoId = videoId;
        this.date = date;
    }
}
