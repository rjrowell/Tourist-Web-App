package com.rjtoursim.api.controller;

import com.rjtoursim.api.model.CreatePostRequest;
import com.rjtoursim.api.model.UserCredentials;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.PostRepository;
import com.rjtoursim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class that adds the implementation for genrerated
 * Api endpoints.
*/
@RestController
public class V1ApiController implements V1Api {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public ResponseEntity<Void> createUser(UserCredentials createUserRequest) {

    //Check if the username is already taken, if so return a 409 Conflict status code
    if (userRepository.findByUsername(createUserRequest.getUsername()).isPresent()) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    User user = new User(createUserRequest.getUsername(), createUserRequest.getHashedPassword());
    userRepository.save(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> pingAuth() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> authenticateUser(UserCredentials authenticateUserRequest) {
    //Check if the username exists
    User user = userRepository.findByUsername(authenticateUserRequest.getUsername()).orElse(null);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    //Check if the password is correct
    if (!user.getPassword().equals(authenticateUserRequest.getHashedPassword())) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> createPost(CreatePostRequest createPostRequest) {
    User user = userRepository.findById(createPostRequest.getUserId().longValue()).orElse(null);
    //Check we find the user, if not return a 400 Bad Request status code. 
    // If the user already has a post with the same title, return a 409 Conflict status code
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else if (postRepository.existsByUserAndTitle(user, createPostRequest.getTitle())) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } 

    Post newPost = new Post(
        user, 
        createPostRequest.getTitle(), 
        createPostRequest.getDescription(), 
        createPostRequest.getAddress(), 
        createPostRequest.getDatePosted().toLocalDateTime()
      );
    
    postRepository.save(newPost);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}