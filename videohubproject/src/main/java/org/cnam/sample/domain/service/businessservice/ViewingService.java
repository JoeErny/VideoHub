package org.cnam.sample.domain.service.businessservice;


import org.cnam.sample.domain.entity.Viewing;
import org.cnam.sample.domain.entity.ViewingToCreate;
import org.cnam.sample.domain.service.unitservice.VideoService;
import org.cnam.sample.repository.ViewingRepository;
import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.VideoModel;
import org.cnam.sample.repository.model.ViewingModel;
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

    public Viewing create(ViewingToCreate viewingToCreate)
    {
       ViewingModel viewingModelCreated  = viewingRepository.save(new ViewingModel(new UserModel(viewingToCreate.userId), new VideoModel(viewingToCreate.videoId), viewingToCreate.date));
        return new Viewing(viewingModelCreated.getId(), viewingModelCreated.getUser().getId(), viewingModelCreated.getVideo().getId(), viewingModelCreated.getDate());
    }

}
