package org.cnam.sample.repository.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "video_id", nullable = true)
    private VideoModel video;

    public OrderModel(Long id, Date date, Double price, UserModel user, VideoModel video) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user = user;
        this.video = video;
    }

    public OrderModel(Date date, Double price, UserModel user, VideoModel video) {
        this.date = date;
        this.price = price;
        this.user = user;
        this.video = video;

    }

    public OrderModel(Long id) {
        this.id = id;
    }

    public OrderModel() {
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public VideoModel getVideo() {
        return video;
    }

    public void setVideo(VideoModel video) {
        this.video = video;
    }
}
