package org.cnam.sample.domain.service.unitservice;


import org.cnam.sample.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import javax.transaction.Transactional;

@Service
@Transactional
public class FidelityPointsService {

    public enum BONUSES {
        HEAVY_PAYMENT_BONUS_STEP(100),
        HEAVY_PAYMENT_BONUS(10),
        NEW_MEMBER_BONUS(20),
        SPONSORED_BONUS(50),
        PATRON_BONUS(50);

        private final int value;

        BONUSES(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }

    @Autowired
    private UserService userService;

    public Integer addFidelityPointsToUser(Integer fidelityPointsToGive, Long userId) {
        User user = userService.getById(userId);
        if (user.fidelity_points == null) {
            user.fidelity_points = 0;
        }

        user.fidelity_points += fidelityPointsToGive;

        userService.update(user);
        return fidelityPointsToGive;
    }

    public Integer convertPaymentAmountToFidelityPoints(Double amount, Long userId) {
        return addFidelityPointsToUser(addBonusForHeavyPayment(amount.intValue()), userId);
    }

    public Integer addBonusForHeavyPayment(Integer fidelityPointsToGive) {
        if (fidelityPointsToGive > BONUSES.HEAVY_PAYMENT_BONUS_STEP.value) {
            fidelityPointsToGive += BONUSES.HEAVY_PAYMENT_BONUS.value;
        }
        return fidelityPointsToGive;
    }


}
