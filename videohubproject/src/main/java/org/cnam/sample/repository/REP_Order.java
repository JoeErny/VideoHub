package org.cnam.sample.repository;

import org.cnam.sample.repository.model.ENTITY_Order;
import org.cnam.sample.repository.model.ENTITY_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface REP_Order extends JpaRepository<ENTITY_Order, Long> {
}
