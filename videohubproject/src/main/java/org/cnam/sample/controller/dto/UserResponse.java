package org.cnam.sample.controller.dto;

public class UserResponse {

    public long id;
    public String name;
    public String firstname;
    public String mail;
    public Integer fidelity_points;


    public UserResponse(long id, String name, String firstname,String mail,Integer fidelity_points) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.fidelity_points = fidelity_points;


    }
}
