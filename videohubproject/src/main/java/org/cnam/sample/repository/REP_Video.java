package org.cnam.sample.repository;


import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.repository.model.ENTITY_Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REP_Video extends JpaRepository<ENTITY_Video, Long> {


}
