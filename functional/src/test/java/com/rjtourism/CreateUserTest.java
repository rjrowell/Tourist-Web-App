package com.rjtourism;


import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.Application;
import com.rjtoursim.api.model.UserCredentials;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;



/**
 * This class contains functional tests for the create user endpoint.
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class CreateUserTest {

  @Autowired
  private MockMvc mockMvc;
    
  @Autowired
  private ObjectMapper objectMapper;
    
  @Autowired
  private UserRepository userRepository;

  @Test
  public void createUserViaApi() throws Exception {
    UserCredentials request = new UserCredentials();
    request.setUsername("testuser");
    request.setHashedPassword("password123");
    request.setIsAdmin(false);

    String requestBody = objectMapper.writeValueAsString(request);
    mockMvc.perform(post("/v1/account/create-user")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestBody))
        .andExpect(status().isCreated());

    // Verify user was created in database
    User foundUser = userRepository.findByUsername("testuser").orElse(null);
    assert foundUser != null : "User was not created in the database";
  }

  @Test
  public void createUserWithExistingUsername() throws Exception {
    userRepository.save(new User("existingUser", "existingPassword", false));

    UserCredentials request = new UserCredentials();
    request.setUsername("existingUser");
    request.setHashedPassword("existingPassword");
    request.setIsAdmin(false);

    try {
      String requestBody = objectMapper.writeValueAsString(request);
      mockMvc.perform(post("/v1/account/create-user")
          .contentType(MediaType.APPLICATION_JSON)
          .content(requestBody))
          .andExpect(status().isConflict());
    } catch (Exception e) {
      fail("Expected a 409 Conflict response but got an exception: " + e.getMessage());
    }
    
  }
}
