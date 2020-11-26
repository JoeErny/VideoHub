package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.entity.VideoToCreate;
import org.cnam.sample.repository.REP_Video;
import org.cnam.sample.repository.model.ENTITY_Category;
import org.cnam.sample.repository.model.ENTITY_Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SERV_Video {

    @Autowired
    private REP_Video videoRepository;

    public Video getById(Long id) {
        ENTITY_Video entityVideoFound = videoRepository.getOne(id);

        return new Video(entityVideoFound.getId(), entityVideoFound.getTitle(), entityVideoFound.getLink(), entityVideoFound.getCategory().getId());
    }

    public Video create(VideoToCreate videoToCreate) {
        ENTITY_Video entityVideoToCreate = new ENTITY_Video(videoToCreate.title, videoToCreate.link, new ENTITY_Category(videoToCreate.category_id));
        ENTITY_Video entityVideoCreated = videoRepository.save(entityVideoToCreate);
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
        ENTITY_Video entityVideoToUpdate = new ENTITY_Video(videoToUpdate.id, videoToUpdate.title, videoToUpdate.link, new ENTITY_Category(videoToUpdate.category_id));
        ENTITY_Video entityVideoUpdated = videoRepository.save(entityVideoToUpdate);
        return new Video(entityVideoUpdated.getId(), entityVideoUpdated.getTitle(), entityVideoUpdated.getLink(), entityVideoUpdated.getCategory().getId());
    }


}
