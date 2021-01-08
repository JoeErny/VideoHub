package org.cnam.sample.domain.service.businessservice;

import net.bytebuddy.asm.Advice;
import org.cnam.sample.domain.entity.*;
import org.cnam.sample.domain.service.unitservice.FidelityPointsService;
import org.cnam.sample.domain.service.unitservice.OrderService;
import org.cnam.sample.domain.service.unitservice.PaymentService;
import org.cnam.sample.domain.service.unitservice.UserService;
import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

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

//        Order orderConcerned = orderService.getById(paymentToCreate.orderId);
//        PaymentModel paymentModelSaved = paymentRepository.save(new PaymentModel(paymentToCreate.amount, new Date(), new OrderModel(paymentToCreate.orderId)));
//        Payment paymentSaved =  new Payment(paymentModelSaved.getId(), paymentModelSaved.getOrder().getId(), paymentModelSaved.getAmount(), paymentModelSaved.getDate());
//        orderConcerned.payment_status = getPaymentStatusOfOrder(paymentToCreate.orderId);
//        orderService.update(orderConcerned);
//
//        if(paymentSaved.amount>0)
//        {
//            fidelityPointsService.convertPaymentAmountToFidelityPoints(paymentSaved.amount, orderService.getById(paymentSaved.orderId).user_id);
//        }
//        return paymentSaved;


        Payment paymentMade = paymentService.commitPaymentNew(new PaymentToCreate(orderToPurchase.getOrderId(), orderToPurchase.getAmount()));

        Integer pointsAdded = 0;
        if (paymentMade.amount > 0) {
            pointsAdded = fidelityPointsService.convertPaymentAmountToFidelityPoints(paymentMade.amount, orderService.getById(paymentMade.orderId).user_id);
        }

        User userConcerned = userService.getById(orderService.getById(paymentMade.orderId).user_id);


//        orderConcerned.payment_status = getPaymentStatusOfOrder(paymentToCreate.orderId);
//        orderService.update(orderConcerned);

        Order orderConcerned = orderService.defineStatus(orderService.getById(orderToPurchase.orderId));


        return new OrderPurchaseResult(paymentMade.id, orderToPurchase.orderId, paymentMade.date, paymentMade.amount, orderConcerned.payment_status, pointsAdded, userConcerned.fidelity_points);
    }


}
