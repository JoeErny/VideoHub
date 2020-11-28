package org.cnam.sample.controller.dto;

import java.util.Date;

public class PaymentResponse {

    public Long id;
    public Long orderId;
    public Double amount;
    public Date date;


    public PaymentResponse(Long id, Long orderId, Double amount, Date date) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.date = date;
    }
}
