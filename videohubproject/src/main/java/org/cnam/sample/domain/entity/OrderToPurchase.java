package org.cnam.sample.domain.entity;

public class OrderToPurchase {

    public Long orderId;
    public Double amount;

    public OrderToPurchase(Long orderId, Double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
