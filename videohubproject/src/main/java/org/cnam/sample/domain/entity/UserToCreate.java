package org.cnam.sample.domain.entity;

public class UserToCreate {

    public String name;
    public String firstname;
    public String mail;


    public UserToCreate(String name, String firstname, String mail) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }
}
