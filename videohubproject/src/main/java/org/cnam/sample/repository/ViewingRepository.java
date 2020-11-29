package org.cnam.sample.repository;

import org.cnam.sample.repository.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewingRepository extends JpaRepository<ViewingModel, Long> {
    List<ViewingModel> findAllByUser(UserModel user);
    List<ViewingModel> findAllByVideo(VideoModel video);
    Long countByVideo(VideoModel video);
    Long countByUser(UserModel user);
}
