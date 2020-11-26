package org.cnam.sample.repository;

import org.cnam.sample.repository.model.ENTITY_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REP_User extends JpaRepository<ENTITY_User, Long> {
}
