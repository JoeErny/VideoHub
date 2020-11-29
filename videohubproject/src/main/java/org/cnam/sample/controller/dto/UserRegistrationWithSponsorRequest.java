package org.cnam.sample.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationWithSponsorRequest {



        public String name;
        public String firstname;
        public String mail;
        public Long sponsor_id;

        @JsonCreator
        public UserRegistrationWithSponsorRequest(@JsonProperty("name") String name, @JsonProperty("firstname") String firstname, @JsonProperty("mail") String mail, @JsonProperty("sponsor_id" )Long sponsor_id) {
            this.name = name;
            this.firstname = firstname;
            this.mail = mail;
            this.sponsor_id = sponsor_id;

        }


}
