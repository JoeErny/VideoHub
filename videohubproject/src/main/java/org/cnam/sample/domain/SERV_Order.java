package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.repository.REP_Order;
import org.cnam.sample.repository.model.ENTITY_Order;
import org.cnam.sample.repository.model.ENTITY_User;
import org.cnam.sample.repository.model.ENTITY_Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class SERV_Order {

    @Autowired
    private REP_Order orderRepository;

    public Order getById(Long id) {
        ENTITY_Order entityOrderFound = orderRepository.getOne(id);
        return new Order(entityOrderFound.getId(), entityOrderFound.getDate(), entityOrderFound.getPrice(), entityOrderFound.getUser().getId(), entityOrderFound.getVideo().getId());
    }

    public Order create(OrderToCreate orderToCreate) {
        ENTITY_Order entityOrderToCreate = new ENTITY_Order( orderToCreate.getDate(), orderToCreate.getPrice(), new ENTITY_User(orderToCreate.getUser_id()), new ENTITY_Video(orderToCreate.getVideo_id()));
        ENTITY_Order entityOrderCreated = orderRepository.save(entityOrderToCreate);
        return new Order(entityOrderCreated.getId(), entityOrderCreated.getDate(), entityOrderCreated.getPrice(), entityOrderCreated.getUser().getId(), entityOrderCreated.getVideo().getId());
    }
}
