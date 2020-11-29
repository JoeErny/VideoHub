package org.cnam.sample.controller.restcontroller;

import org.cnam.sample.controller.dto.UserRegistrationRequest;
import org.cnam.sample.controller.dto.UserRegistrationWithSponsorRequest;
import org.cnam.sample.controller.dto.UserRequest;
import org.cnam.sample.controller.dto.UserResponse;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.domain.entity.UserToCreate;
import org.cnam.sample.domain.entity.UserToRegister;
import org.cnam.sample.domain.service.SponsorshipService;
import org.cnam.sample.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    SponsorshipService sponsorshipService;

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRegistrationRequest userToRegisterRequest) {
        UserToRegister userToRegister = new UserToRegister(userToRegisterRequest.name,userToRegisterRequest.firstname,userToRegisterRequest.mail);

        User userCreated = userService.register(userToRegister);

        UserResponse userResponse = new UserResponse(userCreated.id, userCreated.name,userCreated.firstname,userCreated.mail, userCreated.fidelity_points);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/user/with_sponsor")
    @ResponseBody
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRegistrationWithSponsorRequest userToRegisterRequest) {
        UserToRegister userToRegister = new UserToRegister(userToRegisterRequest.name, userToRegisterRequest.firstname, userToRegisterRequest.mail);

        User userCreated = userService.register(userToRegister);

        UserResponse userResponse = new UserResponse(userCreated.id, userCreated.name, userCreated.firstname, userCreated.mail, userCreated.fidelity_points);

        sponsorshipService.userSponsorsAnother(userToRegisterRequest.sponsor_id, userCreated.id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
