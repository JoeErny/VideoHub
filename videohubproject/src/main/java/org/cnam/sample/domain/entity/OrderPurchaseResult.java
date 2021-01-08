package org.cnam.sample.domain.entity;

import java.util.Date;

public class OrderPurchaseResult {

    public Long paymentId;
    public Long orderId;
    public Date date;
    public Double amount;
    public String orderStatus;
    public Integer fidelityPointsAdded;
    public Integer getFidelityPointsTotal;

    public OrderPurchaseResult(Long paymentId, Long orderId, Date date, Double amount, String orderStatus, Integer fidelityPointsAdded, Integer getFidelityPointsTotal) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.fidelityPointsAdded = fidelityPointsAdded;
        this.getFidelityPointsTotal = getFidelityPointsTotal;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getFidelityPointsAdded() {
        return fidelityPointsAdded;
    }

    public void setFidelityPointsAdded(Integer fidelityPointsAdded) {
        this.fidelityPointsAdded = fidelityPointsAdded;
    }

    public Integer getGetFidelityPointsTotal() {
        return getFidelityPointsTotal;
    }

    public void setGetFidelityPointsTotal(Integer getFidelityPointsTotal) {
        this.getFidelityPointsTotal = getFidelityPointsTotal;
    }
}
