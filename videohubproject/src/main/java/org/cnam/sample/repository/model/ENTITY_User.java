package org.cnam.sample.repository.model;


import org.cnam.sample.domain.entity.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class ENTITY_User {

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


    @OneToMany(mappedBy="user")
    private Set<ENTITY_Order> orders;

    public ENTITY_User() {
    }
    public ENTITY_User(Long id) {
        this.id = id;
    }

    public ENTITY_User(Long id, String name, String firstname, String mail) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }

    public ENTITY_User(String name, String firstname, String mail) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
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

    public Set<ENTITY_Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<ENTITY_Order> orders) {
        this.orders = orders;
    }

}
