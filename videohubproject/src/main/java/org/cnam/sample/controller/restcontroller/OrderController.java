package org.cnam.sample.controller.restcontroller;

import org.cnam.sample.controller.dto.OrderRequest;
import org.cnam.sample.controller.dto.OrderResponse;
import org.cnam.sample.domain.service.BuyingService;
import org.cnam.sample.domain.service.OrderService;
import org.cnam.sample.domain.entity.Order;
import org.cnam.sample.domain.entity.OrderToCreate;
import org.cnam.sample.domain.service.UserService;
import org.hibernate.service.spi.InjectService;
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
    BuyingService buyingService;

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") long id) {
        Order orderFound = orderService.getById(id);

        OrderResponse orderResponse = new OrderResponse(orderFound.getId(), orderFound.getDate(),orderFound.getPrice(), orderFound.getUser_id(), orderFound.getVideo_id());

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping("/user_buy_video")
    @ResponseBody
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderToRequest) {

        OrderToCreate orderToCreate = new OrderToCreate(orderToRequest.getDate(),orderToRequest.getPrice(), orderToRequest.getUser_id(), orderToRequest.getVideo_id());

        Order orderCreated = orderService.create(orderToCreate);

        OrderResponse orderResponse = new OrderResponse(orderCreated.getId(), orderCreated.getDate(),orderCreated.getPrice(), orderCreated.getUser_id(), orderCreated.getVideo_id());

        if(orderResponse.price>0)
        {
            buyingService.addFidelityPointsToUserFromPrice(orderResponse.user_id, orderCreated.price);
        }

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }




}
