package org.cnam.sample.controller.dto;

import java.util.Date;

public class OrderResponse {

    public long id;
    public Date date;
    public double price;
    public long user_id;
    public long video_id;


    public OrderResponse(long id, Date date, double price, long user_id, long video_id) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user_id = user_id;
        this.video_id = video_id;
    }
}
