package org.cnam.sample.domain.service.unitservice;

import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.repository.OrderRepository;
import org.cnam.sample.repository.PaymentRepository;
import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.PaymentModel;
import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Order getById(Long id) {
        OrderModel entityOrderFound = orderRepository.getOne(id);
        return new Order(entityOrderFound.getId(), entityOrderFound.getDate(), entityOrderFound.getPrice(), entityOrderFound.getUser().getId(), entityOrderFound.getVideo().getId(), entityOrderFound.getStatus());
    }

    public Order create(OrderToCreate orderToCreate) {
        if(orderToCreate.price>=0)
        {
            OrderModel entityOrderToCreate = new OrderModel( orderToCreate.getDate(), orderToCreate.getPrice(), new UserModel(orderToCreate.getUser_id()), new VideoModel(orderToCreate.getVideo_id()), PaymentStatusEnum.UNPAID.name());
            OrderModel entityOrderCreated = orderRepository.save(entityOrderToCreate);
            return new Order(entityOrderCreated.getId(), entityOrderCreated.getDate(), entityOrderCreated.getPrice(), entityOrderCreated.getUser().getId(), entityOrderCreated.getVideo().getId(), entityOrderCreated.getStatus());
        }
        else
        {
            return null;
        }
  }
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
    //TODO Demander : Le produit doit-il etre rajouté dans la classe ORDER ou doit il être récupéré de l'ENTITY_ORDER ?
    public Order update(Order orderToUpdate) {
        OrderModel entityOrderToUpdate = new OrderModel(orderToUpdate.getId(), orderToUpdate.getDate(), orderToUpdate.getPrice(), new UserModel(orderToUpdate.user_id), new VideoModel(orderToUpdate.video_id), orderToUpdate.payment_status);
        OrderModel entityOrderUpdated = orderRepository.save(entityOrderToUpdate);
        return new Order(entityOrderUpdated.getId(), entityOrderUpdated.getDate(), entityOrderUpdated.getPrice(), entityOrderUpdated.getUser().getId(), entityOrderUpdated.getVideo().getId(), entityOrderToUpdate.getStatus());
    }

    public String getPaymentStatusOfOrder(Long orderId) {
        Double paymentsTotal = 0.0;
        Order orderConcerned = getById(orderId);
        String paymentStatus = orderConcerned.getPayment_status();

        List<PaymentModel> listPayments = paymentRepository.findAllByOrder(new OrderModel(orderId));
        for (PaymentModel payment : listPayments
        )
        {
            paymentsTotal+=payment.getAmount();
        }

        if(paymentsTotal >= orderConcerned.getPrice())
        {
            paymentStatus = PaymentStatusEnum.PAID.name();
        }
        else if(paymentsTotal<orderConcerned.getPrice())
        {
            paymentStatus = PaymentStatusEnum.PARTIALLY.name();
        }
        else
        {
            paymentStatus = PaymentStatusEnum.UNPAID.name();
        }

        return paymentStatus;
    }

    public Order defineStatus(Order order)
    {
        order.setPayment_status(getPaymentStatusOfOrder(order.id));
        update(order);
        return order;
    }



}
