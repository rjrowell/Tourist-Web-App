package com.rjtourism;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.Application;
import com.rjtoursim.api.model.CreatePostRequest;
import com.rjtoursim.api.model.UserCredentials;
import com.rjtoursim.repository.UserRepository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This class contains functional tests for the post creation endpoint.
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class CreatePostTest {

  @Autowired
  private MockMvc mockMvc;
    
  @Autowired
  private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	public void setup() throws Exception {
		// Setup code to create a user that can be used for creating posts
		UserCredentials request = new UserCredentials();
		request.setUsername("testuser");
		request.setHashedPassword("password123");

		String requestBody = objectMapper.writeValueAsString(request);
				mockMvc.perform(post("/v1/account/create-user")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
						.andExpect(status().isCreated());
	}

	@Test
	public void testCreatePost() throws Exception {
		CreatePostRequest request = new CreatePostRequest();
		request.setUserId(userRepository.findByUsername("testuser").orElse(null).getId().intValue());
		request.setTitle("Test Post");
		request.setDescription("This is a test post.");
		request.setAddress("123 Test Street");
		request.setDatePosted(java.time.OffsetDateTime.parse("2023-01-01T00:00:00Z"));

		String requestBody = objectMapper.writeValueAsString(request);
				mockMvc.perform(post("/v1/content/create-post")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
						.andExpect(status().isCreated());
	}
}
