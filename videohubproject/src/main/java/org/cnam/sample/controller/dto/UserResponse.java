package org.cnam.sample.controller.dto;

public class UserResponse {

    public long id;

    public String name;
    public String firstname;
    public String mail;

    public UserResponse(long id, String name, String firstname,String mail) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }
}
