package org.cnam.sample.domain.entity;

public class User {

    public Long id;

    public String name;
    public String firstname;
    public String mail;


    public User(Long id, String name, String firstname, String mail) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }
}
