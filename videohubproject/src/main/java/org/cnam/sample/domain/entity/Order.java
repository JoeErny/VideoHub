package org.cnam.sample.domain.entity;

import java.util.Date;

public class Order {

    public Long id;
    public Date date;
    public Double price;
    public Long user_id;
    public Long video_id;

    public Order(Long id, Date date, Double price, Long user_id, Long video_id) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user_id = user_id;
        this.video_id = video_id;
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
}
