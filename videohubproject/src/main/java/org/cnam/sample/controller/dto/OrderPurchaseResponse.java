package org.cnam.sample.controller.dto;

import java.util.Date;

public class OrderPurchaseResponse {

    public Long paymentId;
    public Long orderId;
    public Date date;
    public Double amount;
    public String orderStatus;
    public Integer fidelityPointsAdded;
    public Integer getFidelityPointsTotal;

    public OrderPurchaseResponse(Long paymentId, Long orderId, Date date, Double amount, String orderStatus, Integer fidelityPointsAdded, Integer getFidelityPointsTotal) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.fidelityPointsAdded = fidelityPointsAdded;
        this.getFidelityPointsTotal = getFidelityPointsTotal;
    }
}
