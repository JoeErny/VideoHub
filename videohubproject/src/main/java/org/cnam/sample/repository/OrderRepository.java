package org.cnam.sample.repository;

import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    List<OrderModel> findAllOrdersByUserAndStatus(UserModel user, String status);
}
