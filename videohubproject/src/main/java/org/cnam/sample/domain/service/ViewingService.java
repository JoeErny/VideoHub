package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.repository.VideoRepository;
import org.cnam.sample.repository.ViewingRepository;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ViewingService {

    @Autowired
    private ViewingRepository viewingRepository;

    @Autowired
    private VideoService videoService;

    public Long countByVideoId (Long videoId)
    {
        return viewingRepository.countByVideo(new VideoModel(videoId));
    }

    public Long countByUserId (Long userId)
    {
        return viewingRepository.countByVideo(new VideoModel(userId));
    }




}
