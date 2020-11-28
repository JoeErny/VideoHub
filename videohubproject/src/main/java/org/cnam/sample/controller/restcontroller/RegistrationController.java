package org.cnam.sample.controller.restcontroller;

import org.cnam.sample.controller.dto.UserRequest;
import org.cnam.sample.controller.dto.UserResponse;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.domain.entity.UserToCreate;
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

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userToRequest) {
        UserToCreate userToCreate = new UserToCreate(userToRequest.name,userToRequest.firstname,userToRequest.mail,userToRequest.fidelity_points );

        User userCreated = userService.create(userToCreate);

        UserResponse userResponse = new UserResponse(userCreated.id, userCreated.name,userCreated.firstname,userCreated.mail, userCreated.fidelity_points);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/with_sponsor")
    @ResponseBody
    public ResponseEntity<UserResponse> createUserBySponsoring(@RequestBody UserRequest userToRequest) {
        UserToCreate userToCreate = new UserToCreate(userToRequest.name,userToRequest.firstname,userToRequest.mail,userToRequest.fidelity_points );

        User userCreated = userService.create(userToCreate);

        UserResponse userResponse = new UserResponse(userCreated.id, userCreated.name,userCreated.firstname,userCreated.mail, userCreated.fidelity_points);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
