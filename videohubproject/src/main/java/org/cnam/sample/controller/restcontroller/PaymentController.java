package org.cnam.sample.controller.restcontroller;


import org.cnam.sample.controller.dto.OrderRequest;
import org.cnam.sample.controller.dto.OrderResponse;
import org.cnam.sample.controller.dto.PaymentRequest;
import org.cnam.sample.controller.dto.PaymentResponse;
import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.domain.entity.Payment;
import org.cnam.sample.domain.entity.PaymentToCreate;
import org.cnam.sample.domain.service.OrderService;
import org.cnam.sample.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable("id") long id) {
        Payment paymentFound = paymentService.getById(id);
        PaymentResponse paymentResponse = new PaymentResponse(paymentFound.getId(),paymentFound.getOrderId(),paymentFound.getAmount(), paymentFound.getDate());
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentToRequest) {

        PaymentToCreate paymentToCreate = new PaymentToCreate(paymentToRequest.getOrderId(), paymentToRequest.getAmount());
        Payment paymentCreated = paymentService.commitPayment(paymentToCreate);
        PaymentResponse paymentResponse = new PaymentResponse(paymentCreated.getId(), paymentCreated.getOrderId(),paymentCreated.getAmount(), paymentCreated.getDate());
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

}
