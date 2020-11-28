package org.cnam.sample.domain.entity;

import javax.persistence.criteria.CriteriaBuilder;

public class UserToCreate {

    public String name;
    public String firstname;
    public String mail;
    public Integer fidelity_points;
    public Long sponsor_id;


    public UserToCreate(String name, String firstname, String mail,Integer fidelity_points, Long sponsor_id ) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.fidelity_points = fidelity_points;
        this.sponsor_id = sponsor_id;
    }
}
