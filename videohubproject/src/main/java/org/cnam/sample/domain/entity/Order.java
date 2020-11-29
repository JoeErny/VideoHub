package org.cnam.sample.domain.entity;

import java.util.Date;

public class Order {

    public Long id;
    public Date date;
    public Double price;
    public Long user_id;
    public Long video_id;
    public String payment_status;

    public Order(Long id, Date date, Double price, Long user_id, Long video_id, String payment_status) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user_id = user_id;
        this.video_id = video_id;
        this.payment_status = payment_status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }
    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
}
