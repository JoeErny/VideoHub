package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.domain.entity.User;
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
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    //Le produit doit-il etre rajouté dans la classe ORDER ou doit il être récupéré de l'ENTITY_ORDER ?
    public Order update(Order orderToUpdate) {

        ENTITY_Order entityOrderToUpdate = new ENTITY_Order(orderToUpdate.getId(), orderToUpdate.getDate(), orderToUpdate.getPrice(), new ENTITY_User(orderToUpdate.user_id), new ENTITY_Video(orderToUpdate.video_id));
        ENTITY_Order entityOrderUpdated = orderRepository.save(entityOrderToUpdate);
        return new Order(entityOrderUpdated.getId(), entityOrderUpdated.getDate(), entityOrderUpdated.getPrice(), entityOrderUpdated.getUser().getId(), entityOrderUpdated.getVideo().getId());
    }



}
