package org.cnam.sample.domain.service;

import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.entity.VideoToCreate;
import org.cnam.sample.repository.VideoRepository;
import org.cnam.sample.repository.model.CategoryModel;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video getById(Long id) {
        VideoModel entityVideoFound = videoRepository.getOne(id);

        return new Video(entityVideoFound.getId(), entityVideoFound.getTitle(), entityVideoFound.getLink(), entityVideoFound.getCategory().getId());
    }

    public Video create(VideoToCreate videoToCreate) {
        VideoModel entityVideoToCreate = new VideoModel(videoToCreate.title, videoToCreate.link, new CategoryModel(videoToCreate.category_id));
        VideoModel entityVideoCreated = videoRepository.save(entityVideoToCreate);
        return new Video(entityVideoCreated.getId(), entityVideoCreated.getTitle(), entityVideoCreated.getLink(), entityVideoCreated.getCategory().getId());
    }

    public void deleteById(long id) {
        try {
            videoRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Video update(Video videoToUpdate) {
        VideoModel entityVideoToUpdate = new VideoModel(videoToUpdate.id, videoToUpdate.title, videoToUpdate.link, new CategoryModel(videoToUpdate.category_id));
        VideoModel entityVideoUpdated = videoRepository.save(entityVideoToUpdate);
        return new Video(entityVideoUpdated.getId(), entityVideoUpdated.getTitle(), entityVideoUpdated.getLink(), entityVideoUpdated.getCategory().getId());
    }


}
