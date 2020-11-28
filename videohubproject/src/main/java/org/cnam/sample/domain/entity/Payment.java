package org.cnam.sample.domain.entity;

import java.util.Date;

public class Payment {

    public Long id;
    public Long orderId;
    public Date date;
    public Double amount;

    public Payment(Long id, Long orderId, Double amount, Date date) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
