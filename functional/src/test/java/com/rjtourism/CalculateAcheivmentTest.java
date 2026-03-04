package com.rjtourism;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.Application;
import com.rjtoursim.api.model.CalculateAchievementResponse;
import com.rjtoursim.entity.Category;
import com.rjtoursim.entity.Like;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.CategoryRepository;
import com.rjtoursim.repository.LikeRepository;
import com.rjtoursim.repository.PostRepository;
import com.rjtoursim.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This class contains functional tests for achievement calculation features.
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class CalculateAcheivmentTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private LikeRepository likeRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private boolean setupFlag = false;

  /**
   * Set up test data before each test case.
   * This method will create a user and posts for testing achievement calculation.
   *
   * @throws Exception if there is an error during setup
   */
  @BeforeEach
  public void setup() throws Exception {
    if (!setupFlag) {
      // Setup code to create a user and posts for testing achievements
      User testUser = new User("testuser", "password123", false);
      userRepository.save(testUser);

      java.time.LocalDateTime datePosted = java.time.Instant.parse("2023-01-01T00:00:00Z")
          .atZone(java.time.ZoneId.systemDefault())
          .toLocalDateTime();

      Integer catId = 1;
      Category testCategory = categoryRepository.findById((catId.longValue())).orElse(null);
      
      Post testPost = new Post(
          testUser,
          testCategory,
          "Test Post",
          "A test post for achievements",
          "123 Test Street",
          datePosted
      );
      postRepository.save(testPost);

      setupFlag = true;
    }
  }

  @Test
  public void test5LikeAcheivement() throws Exception {
    // Get the test user and post
    User testUser = userRepository.findByUsername("testuser").orElseThrow();
    Post testPost = postRepository.findAll().stream().findFirst().orElseThrow();
    
    // Create 5 likes assigned to the user
    for (int i = 0; i < 5; i++) {
      Like like = new Like(testPost, testUser, true);
      likeRepository.save(like);
    }

    CalculateAchievementResponse response = objectMapper.readValue(
        mockMvc.perform(get("/v1/account/calculate-achievement/" + testUser.getId()))
          .andExpect(status().isOk())
          .andReturn()
          .getResponse()
          .getContentAsString(),
        CalculateAchievementResponse.class
    );

    assertTrue(response.getFiveLikesAchievement(), 
        "5 Likes achievement should be awarded when user has 5 or more likes");
  }
}
