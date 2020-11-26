package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
    public String name;
    public String firstname;
    public String mail;

    @JsonCreator
    public UserRequest(@JsonProperty("name") String name, @JsonProperty("firstname") String firstname, @JsonProperty("mail") String mail ) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
    }
}
