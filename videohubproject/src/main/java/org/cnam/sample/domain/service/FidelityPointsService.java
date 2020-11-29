package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FidelityPointsService {

    public enum BONUSES{
        HEAVY_PAYMENT_BONUS_STEP(100),
        HEAVY_PAYMENT_BONUS(10),
        NEW_MEMBER_BONUS(20),
        SPONSORED_BONUS(50),
        PATRON_BONUS(50);

        private final int value;
        BONUSES(final int newValue) {
            value = newValue;
        }
        public int getValue() { return value; }
    }

    @Autowired
    private UserService userService;

    public void addFidelityPointsToUser(Integer fidelityPointsToGive, Long userId)
    {
            User user = userService.getById(userId);
            user.fidelity_points += fidelityPointsToGive;
            userService.update(user);
    }

    public void convertPaymentAmountToFidelityPoints(Double amount, Long userId)
    {
        addFidelityPointsToUser(addBonusForHeavyPayment(amount.intValue()), userId);
    }

    public Integer addBonusForHeavyPayment( Integer fidelityPointsToGive)
    {
        if (fidelityPointsToGive > BONUSES.HEAVY_PAYMENT_BONUS_STEP.value)
        {
            fidelityPointsToGive += BONUSES.HEAVY_PAYMENT_BONUS.value;
        }
        return fidelityPointsToGive;
    }


}
