package org.cnam.sample.repository;


import org.cnam.sample.repository.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {


}
