package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SponsorshipService {

    @Autowired
    private UserService userService;

    public void addFidelityPointsToUserOnInscription(User userToGiveFidelityPoints)
    {

    }
    public void userSponsorsAnother(User sponsor, User sponsorized)
    {

    }

}
