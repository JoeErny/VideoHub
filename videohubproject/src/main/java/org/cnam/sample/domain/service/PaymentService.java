package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.Payment;
import org.cnam.sample.domain.entity.PaymentToCreate;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.repository.PaymentRepository;
import org.cnam.sample.repository.SampleRepository;
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
        // TODO Est-ce qu'on fait la vérif du paiement accepté par la banque ?
        Order orderConcerned = orderService.getById(paymentToCreate.orderId);
        PaymentModel paymentModelSaved = paymentRepository.save(new PaymentModel(paymentToCreate.amount, new Date(), new OrderModel(paymentToCreate.orderId)));
        orderConcerned.payment_status = getPaymentStatusOfOrder(paymentToCreate.orderId);
        orderService.update(orderConcerned);
        return new Payment(paymentModelSaved.getId(), paymentModelSaved.getOrder().getId(), paymentModelSaved.getAmount(), paymentModelSaved.getDate());
    }

    public void addFidelityPointsToUserFromPrice(Long userIdToUpdate, Double price) {
        System.out.print("YYYYYYYYYYYYYYYYYYYYYYUPDATE USER : "+userIdToUpdate);
        Integer pointsToAdd = price.intValue();
        User userToGivePoints = userService.getById(userIdToUpdate);
        fidelityPointsService.addFidelityPointsToUser(pointsToAdd, userToGivePoints);
    }

    public String getPaymentStatusOfOrder(Long orderId) {
        Double paymentsTotal = 0.0;
        String paymentStatus = null;

        Order orderConcerned = orderService.getById(orderId);


        List<PaymentModel> listPayments = paymentRepository.findAllByOrder(new OrderModel(orderId));
        for (PaymentModel payment : listPayments
        ) {
            paymentsTotal+=payment.getAmount();
        }

        if(paymentsTotal.equals(orderConcerned.getPrice()))
        {
            paymentStatus = PaymentStatusEnum.PAID.name();
        }

        return paymentStatus;
    }


}
