package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.User;
import org.cnam.sample.domain.entity.UserToCreate;
import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.domain.entity.VideoToCreate;
import org.cnam.sample.repository.REP_User;
import org.cnam.sample.repository.REP_Video;
import org.cnam.sample.repository.model.ENTITY_User;
import org.cnam.sample.repository.model.ENTITY_Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SERV_User {

    @Autowired
    private REP_User userRepository;

    public User getById(Long id) {
        ENTITY_User entityUserFound = userRepository.getOne(id);
        return new User(entityUserFound.getId(), entityUserFound.getName(), entityUserFound.getFirstname(), entityUserFound.getMail());
    }

    public User create(UserToCreate userToCreate) {
        ENTITY_User entityUserToCreate = new ENTITY_User(userToCreate.name, userToCreate.firstname, userToCreate.mail);
        ENTITY_User entityUserCreated = userRepository.save(entityUserToCreate);
        return new User(entityUserCreated.getId(), entityUserCreated.getName(), entityUserCreated.getFirstname(), entityUserCreated.getMail());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }



}
