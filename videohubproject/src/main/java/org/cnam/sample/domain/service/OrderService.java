package org.cnam.sample.domain.service;

import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.repository.OrderRepository;
import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getById(Long id) {
        OrderModel entityOrderFound = orderRepository.getOne(id);
        return new Order(entityOrderFound.getId(), entityOrderFound.getDate(), entityOrderFound.getPrice(), entityOrderFound.getUser().getId(), entityOrderFound.getVideo().getId());
    }

    public Order create(OrderToCreate orderToCreate) {

        OrderModel entityOrderToCreate = new OrderModel( orderToCreate.getDate(), orderToCreate.getPrice(), new UserModel(orderToCreate.getUser_id()), new VideoModel(orderToCreate.getVideo_id()));
        OrderModel entityOrderCreated = orderRepository.save(entityOrderToCreate);
        return new Order(entityOrderCreated.getId(), entityOrderCreated.getDate(), entityOrderCreated.getPrice(), entityOrderCreated.getUser().getId(), entityOrderCreated.getVideo().getId());
    }
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    //TODO Demander : Le produit doit-il etre rajouté dans la classe ORDER ou doit il être récupéré de l'ENTITY_ORDER ?
    public Order update(Order orderToUpdate) {

        OrderModel entityOrderToUpdate = new OrderModel(orderToUpdate.getId(), orderToUpdate.getDate(), orderToUpdate.getPrice(), new UserModel(orderToUpdate.user_id), new VideoModel(orderToUpdate.video_id));
        OrderModel entityOrderUpdated = orderRepository.save(entityOrderToUpdate);
        return new Order(entityOrderUpdated.getId(), entityOrderUpdated.getDate(), entityOrderUpdated.getPrice(), entityOrderUpdated.getUser().getId(), entityOrderUpdated.getVideo().getId());
    }



}
