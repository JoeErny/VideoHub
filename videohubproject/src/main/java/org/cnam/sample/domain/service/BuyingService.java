package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuyingService {


    @Autowired
    private UserService userService;
    @Autowired
    private FidelityPointsService fidelityPointsService;

    public void addFidelityPointsToUserFromPrice(Long userIdToUpdate, Double price)
    {
        Integer pointsToAdd = price.intValue();
        User userToGivePoints = userService.getById(userIdToUpdate);
        fidelityPointsService.addFidelityPointsToUser(pointsToAdd, userToGivePoints);
    }









}
