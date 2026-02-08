package com.rjtoursim.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rjtoursim.api.model.CreateUserRequest;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.UserRepository;

/**
 * Controller class that adds the implementation for genrerated
 * Api endpoints.
*/
@RestController
public class V1ApiController implements V1Api {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Void> createUser(CreateUserRequest createUserRequest) {
        
        //Check if the username is already taken, if so return a 409 Conflict status code
        if (userRepository.findByUsername(createUserRequest.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        User user = new User(createUserRequest.getUsername(), createUserRequest.getHashedPassword());
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}