package org.cnam.sample.domain.service.businessservice;

import org.cnam.sample.domain.entity.*;
import org.cnam.sample.domain.service.unitservice.FidelityPointsService;
import org.cnam.sample.domain.service.unitservice.OrderService;
import org.cnam.sample.domain.service.unitservice.PaymentService;
import org.cnam.sample.domain.service.unitservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderPurchaseService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private FidelityPointsService fidelityPointsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    public OrderPurchaseResult purchaseOrder(OrderToPurchase orderToPurchase) {

        Payment paymentMade = paymentService.createNewPayment(new PaymentToCreate(orderToPurchase.getOrderId(), orderToPurchase.getAmount()));

        Integer pointsAdded = 0;
        if (paymentMade.amount > 0) {
            pointsAdded = fidelityPointsService.convertPaymentAmountToFidelityPoints(paymentMade.amount, orderService.getById(paymentMade.orderId).user_id);
        }

        User userConcerned = userService.getById(orderService.getById(paymentMade.orderId).user_id);
        Order orderConcerned = orderService.defineStatus(orderService.getById(orderToPurchase.orderId));

        return new OrderPurchaseResult(paymentMade.id, orderToPurchase.orderId, paymentMade.date, paymentMade.amount, orderConcerned.payment_status, pointsAdded, userConcerned.fidelity_points);
    }
}
