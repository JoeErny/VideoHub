package org.cnam.sample.controller.restcontroller.business;

import org.cnam.sample.controller.dto.OrderPurchaseRequest;
import org.cnam.sample.controller.dto.OrderPurchaseResponse;
import org.cnam.sample.controller.dto.PaymentResponse;
import org.cnam.sample.domain.entity.OrderPurchaseResult;
import org.cnam.sample.domain.entity.OrderToPurchase;
import org.cnam.sample.domain.entity.Payment;
import org.cnam.sample.domain.entity.PaymentToCreate;
import org.cnam.sample.domain.service.businessservice.OrderPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderpurchase")

public class OrderPurchaseController {

    @Autowired
    OrderPurchaseService orderPurchaseService;

    @PostMapping("/purchaseorder")
    @ResponseBody
    public ResponseEntity<OrderPurchaseResponse> purchaseOrder(@RequestBody OrderPurchaseRequest orderPurchaseRequest) {

        OrderPurchaseResult orderPurchaseResult = orderPurchaseService.purchaseOrder(new OrderToPurchase(orderPurchaseRequest.getOrderId(), orderPurchaseRequest.getAmount()));
        OrderPurchaseResponse orderPurchaseResponse = new OrderPurchaseResponse(orderPurchaseResult.paymentId, orderPurchaseResult.orderId, orderPurchaseResult.date, orderPurchaseResult.amount, orderPurchaseResult.orderStatus, orderPurchaseResult.fidelityPointsAdded, orderPurchaseResult.getFidelityPointsTotal);
        return new ResponseEntity<>(orderPurchaseResponse, HttpStatus.OK);
    }
}
