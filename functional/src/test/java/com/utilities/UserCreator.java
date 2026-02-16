package com.utilities;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.api.model.UserCredentials;
import com.rjtoursim.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Utility class for creating test users in the database.
 */
@AutoConfigureMockMvc
@Transactional
public class UserCreator {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MockMvc mockMvc;

  /**
   * Create a test user with the username "testuser" and password "password123" 
   * if it does not already exist.
   *
   * @throws Exception if there is an error during user creation
   */
  public void createTestUser() throws Exception {
    if (!userRepository.findByUsername("testuser").isPresent()) {
      UserCredentials request = new UserCredentials();
      request.setUsername("testuser");
      request.setHashedPassword("password123");

      String requestBody = objectMapper.writeValueAsString(request);
      mockMvc.perform(post("/v1/account/create-user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isCreated());
    }
  }
}
