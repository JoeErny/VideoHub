package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
    public String name;
    public String firstname;
    public String mail;
    public Integer fidelity_points;

    @JsonCreator
    public UserRequest(@JsonProperty("name") String name, @JsonProperty("firstname") String firstname, @JsonProperty("mail") String mail,  @JsonProperty("fidelity_points")Integer fidelity_points) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.fidelity_points = fidelity_points;
    }
}
