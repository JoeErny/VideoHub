package org.cnam.sample.domain.service.businessservice;


import org.cnam.sample.domain.entity.User;
import org.cnam.sample.domain.service.unitservice.FidelityPointsService;
import org.cnam.sample.domain.service.unitservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SponsorshipService {

    @Autowired
    private UserService userService;

    @Autowired
    private FidelityPointsService fidelityPointsService;


    public void userSponsorsAnother(Long idSponsoringUser, Long idSponsorizedUser)
    {
        User sponsoringUser = userService.getById(idSponsoringUser);
        User sponsorizedUser = userService.getById(idSponsorizedUser);

        if(sponsoringUser.id != null && sponsorizedUser.id != null)
        {
            fidelityPointsService.addFidelityPointsToUser(FidelityPointsService.BONUSES.SPONSORED_BONUS.getValue(),sponsorizedUser.id);
            fidelityPointsService.addFidelityPointsToUser(FidelityPointsService.BONUSES.PATRON_BONUS.getValue(),sponsoringUser.id);
        }

    }

}
