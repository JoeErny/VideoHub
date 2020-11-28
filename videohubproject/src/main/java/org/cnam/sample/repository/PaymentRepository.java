package org.cnam.sample.repository;

import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

    List<PaymentModel> findAllByOrder(OrderModel order);

}
