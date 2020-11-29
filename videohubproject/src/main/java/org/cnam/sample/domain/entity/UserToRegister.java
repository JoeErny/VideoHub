package org.cnam.sample.domain.entity;

public class UserToRegister {

    public String name;
    public String firstname;
    public String mail;

    public UserToRegister(String name, String firstname, String mail) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }
}
