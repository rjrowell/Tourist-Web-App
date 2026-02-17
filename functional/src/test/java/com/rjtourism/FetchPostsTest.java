package com.rjtourism;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.Application;
import com.rjtoursim.api.model.FetchPostsResponse;
import com.rjtoursim.api.model.PostDTO;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.PostRepository;
import com.rjtoursim.repository.UserRepository;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;


/**
 * This class contains functional tests for the post fetching endpoint.
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class FetchPostsTest {
  @Autowired
  UserRepository userRepository;

  @Autowired
  PostRepository postRepository;

  @Autowired
  private MockMvc mockMvc;
    
  @Autowired
  private ObjectMapper objectMapper;
  
  private boolean setupFlag = false;

  /**
   * Set up test data before each test case. 
   * This method will create a user and some posts that can be used for fetching posts.

   * @throws Exception if there is an error during setup
   */
  @BeforeEach
  public void setup() throws Exception {
    if (!setupFlag) {
      // Setup code to create a user and some posts that can be used for fetching posts
      // create a user
      User testUser = new User("testuser", "password123");
      userRepository.save(testUser);

      java.time.LocalDateTime datePosted = java.time.Instant.parse("2023-01-01T00:00:00Z")
          .atZone(java.time.ZoneId.systemDefault())
          .toLocalDateTime();

      Post testPost1 = new Post(
          testUser, 
          "Test Post 1",
          "A test post", 
          "123 Test Post Lane", 
          datePosted
        );

      Post testPost2 = new Post(
          testUser, 
          "Test Post 2",
          "A test post", 
          "123 Test Post Lane", 
          datePosted
      );

      postRepository.save(testPost1);
      postRepository.save(testPost2);

      setupFlag = true;
    }
  }

  @Test
  public void testFetchPosts() throws Exception {
    // Test code to fetch posts and verify the response
    FetchPostsResponse response = objectMapper.readValue(
        mockMvc.perform(get("/v1/content/fetch-posts"))
          .andExpect(status().isOk())
          .andReturn()
          .getResponse()
          .getContentAsString(), FetchPostsResponse.class);
    
    List<PostDTO> posts = response.getPosts();
    assertTrue(response.getPosts().size() == 2, "Expected 2 posts but got " + response.getPosts().size());
    assertTrue(posts.get(0).getTitle().equals("Test Post 1") &&
          posts.get(1).getTitle().equals("Test Post 2"), 
          "Post titles do not match expected values");
  }
}
