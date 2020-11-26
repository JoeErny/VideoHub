package org.cnam.sample.repository.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class ENTITY_Order {

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
    private ENTITY_User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "video_id", nullable = true)
    private ENTITY_Video video;

    public ENTITY_Order(Long id, Date date, Double price, ENTITY_User user, ENTITY_Video video) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user = user;
        this.video = video;
    }

    public ENTITY_Order(Date date, Double price, ENTITY_User user, ENTITY_Video video) {
        this.date = date;
        this.price = price;
        this.user = user;
        this.video = video;
    }

    public ENTITY_Order(Long id) {
        this.id = id;
    }

    public ENTITY_Order() {
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

    public ENTITY_User getUser() {
        return user;
    }

    public void setUser(ENTITY_User user) {
        this.user = user;
    }

    public ENTITY_Video getVideo() {
        return video;
    }

    public void setVideo(ENTITY_Video video) {
        this.video = video;
    }
}
