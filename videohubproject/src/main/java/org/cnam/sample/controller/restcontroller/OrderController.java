package org.cnam.sample.controller.restcontroller;

import org.cnam.sample.controller.dto.OrderRequest;
import org.cnam.sample.controller.dto.OrderResponse;
import org.cnam.sample.domain.service.PaymentService;
import org.cnam.sample.domain.service.OrderService;
import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") long id) {
        Order orderFound = orderService.getById(id);

        OrderResponse orderResponse = new OrderResponse(orderFound.getId(), orderFound.getDate(),orderFound.getPrice(), orderFound.getUser_id(), orderFound.getVideo_id());
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderToRequest) {

        OrderToCreate orderToCreate = new OrderToCreate(orderToRequest.getDate(),orderToRequest.getPrice(), orderToRequest.getUser_id(), orderToRequest.getVideo_id());

        Order orderCreated = orderService.create(orderToCreate);

        OrderResponse orderResponse = new OrderResponse(orderCreated.getId(), orderCreated.getDate(),orderCreated.getPrice(), orderCreated.getUser_id(), orderCreated.getVideo_id());

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }




}
