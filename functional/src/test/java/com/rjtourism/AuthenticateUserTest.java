package com.rjtourism;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.Application;
import com.rjtoursim.api.model.UserCredentials;
import com.rjtoursim.repository.UserRepository;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class AuthenticateUserTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UserRepository userRepository;

	private UserCredentials request = new UserCredentials();

	@BeforeEach
	public void setup() {
		request.setUsername("testuser");
		request.setHashedPassword("password123");

		// Only create the user if it doesn't already exist in the database
		if (userRepository.findByUsername("testuser").isEmpty()) {
			try {
				String requestBody = objectMapper.writeValueAsString(request);
				mockMvc.perform(post("/v1/account/create-user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(status().isCreated());
			} catch (Exception e) {
				fail("Failed to create user: " + e.getMessage());
			}
		}

	}
    
	@Test
	public void pingAuthenticationController() {
		//Send a ping request to the authentication controller to see if it is reachable
		try {
			mockMvc.perform(get("/v1/authentication")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		} catch (Exception e) {
			fail("Failed to ping authentication controller: " + e.getMessage());
		}
	}

	@Test
	public void authenticateUserViaAPI() {
		//Test the user from setup can be authenticated successfully
		try {
			String requestBody = objectMapper.writeValueAsString(request);
			mockMvc.perform(post("/v1/authentication/authenticate-user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody))
			.andExpect(status().isOk());
		} catch (Exception e) {
			fail("Failed to authenticate user: " + e.getMessage());
		}
  }

	@Test
	public void authenticateUserWithInvalidCredentials() {
		//Change the password to an incorrect one and verify that authentication fails with a 401 Unauthorized status code
		request.setHashedPassword("wrongPass");

		try {
			String requestBody = objectMapper.writeValueAsString(request);
			mockMvc.perform(post("/v1/authentication/authenticate-user")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody))
			.andExpect(status().isUnauthorized());
		} catch (Exception e) {
			fail("Failed to authenticate user with invalid credentials: " + e.getMessage());
		}
	}
}
