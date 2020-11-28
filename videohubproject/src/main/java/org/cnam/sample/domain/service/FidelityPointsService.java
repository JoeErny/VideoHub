package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FidelityPointsService {

    @Autowired
    private UserService userService;

    private final Integer BONUS_STEP = 100;
    private final Integer BONUS = 10;

    public void addFidelityPointsToUser(Integer fidelityPointsToGive, User user)
    {
            Integer pointsToAdd = fidelityPointsToGive;
            if (fidelityPointsToGive > BONUS_STEP)
            {
                pointsToAdd += BONUS;
            }
            user.fidelity_points += pointsToAdd;
            System.out.print("XXXXXXXXXXXXXXXXXXXUPDATE USER : "+user);
            userService.update(user);
    }
}
