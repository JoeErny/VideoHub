package org.cnam.sample.repository.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "mail", unique = true)
    private String mail;
    @Column(name = "fidelity_points")
    private Integer fidelity_points;

    @OneToMany(mappedBy="user")
    private Set<OrderModel> orders;

    public UserModel() {
    }
    public UserModel(Long id) {
        this.id = id;
    }

    public UserModel(Long id, String name, String firstname, String mail,  Integer fidelity_points) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.fidelity_points = fidelity_points;
    }

    public UserModel(String name, String firstname, String mail , Integer fidelity_points) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.fidelity_points = fidelity_points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderModel> orders) {
        this.orders = orders;
    }

    public Integer getFidelity_points() {
        return fidelity_points;
    }

    public void setFidelity_points(Integer fidelity_points) {
        this.fidelity_points = fidelity_points;
    }

}
