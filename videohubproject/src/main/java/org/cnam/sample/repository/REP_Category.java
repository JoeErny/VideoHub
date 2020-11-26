package org.cnam.sample.repository;

import org.cnam.sample.repository.model.ENTITY_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REP_Category extends JpaRepository<ENTITY_Category, Long> {
}
