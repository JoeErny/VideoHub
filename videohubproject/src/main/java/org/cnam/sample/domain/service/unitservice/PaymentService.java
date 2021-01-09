package org.cnam.sample.domain.service.unitservice;


import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.Payment;
import org.cnam.sample.domain.entity.PaymentToCreate;
import org.cnam.sample.repository.PaymentRepository;
import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository;


    @Autowired
    private UserService userService;
    @Autowired
    private FidelityPointsService fidelityPointsService;
    @Autowired
    private OrderService orderService;



    public Payment getById(Long id)
    {
        PaymentModel paymentModel = paymentRepository.getOne(id);
        return new Payment(paymentModel.getId() , paymentModel.getOrder().getId(), paymentModel.getAmount(), paymentModel.getDate()) ;
    }

    public Payment commitPayment(PaymentToCreate paymentToCreate) {
        // TODO Supprimer cette methode ?
        Order orderConcerned = orderService.getById(paymentToCreate.orderId);
        PaymentModel paymentModelSaved = paymentRepository.save(new PaymentModel(paymentToCreate.amount, new Date(), new OrderModel(paymentToCreate.orderId)));
        Payment paymentSaved =  new Payment(paymentModelSaved.getId(), paymentModelSaved.getOrder().getId(), paymentModelSaved.getAmount(), paymentModelSaved.getDate());
        orderConcerned.payment_status = orderService.getPaymentStatusOfOrder(paymentToCreate.orderId);
        orderService.update(orderConcerned);

        if(paymentSaved.amount>0)
        {
            fidelityPointsService.convertPaymentAmountToFidelityPoints(paymentSaved.amount, orderService.getById(paymentSaved.orderId).user_id);
        }
        return paymentSaved;
    }

    public Payment createNewPayment(PaymentToCreate paymentToCreate) {
        Order orderConcerned = orderService.getById(paymentToCreate.orderId);
        PaymentModel paymentModelSaved = paymentRepository.save(new PaymentModel(paymentToCreate.amount, new Date(), new OrderModel(paymentToCreate.orderId)));
        return new Payment(paymentModelSaved.getId(), paymentModelSaved.getOrder().getId(), paymentModelSaved.getAmount(), paymentModelSaved.getDate());
    }

}
