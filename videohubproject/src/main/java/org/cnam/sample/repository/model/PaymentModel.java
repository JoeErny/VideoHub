package org.cnam.sample.repository.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment_table")
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Double amount;


    @Column(name = "date")
    private Date date;


    @ManyToOne
    private OrderModel order;

    public PaymentModel(Long id, Double amount, Date date, OrderModel order) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.order = order;
    }

    public PaymentModel(Double amount, Date date, OrderModel order) {
        this.amount = amount;
        this.date = date;
        this.order = order;
    }

    public PaymentModel(Long id) {
        this.id = id;
    }

    public PaymentModel() {
    }


    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
