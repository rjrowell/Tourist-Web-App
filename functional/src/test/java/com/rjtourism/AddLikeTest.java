package com.rjtourism;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rjtoursim.Application;
import com.rjtoursim.api.model.FetchLikesResponse;
import com.rjtoursim.api.model.GetLikeResponse;
import com.rjtoursim.api.model.LikeRequest;
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
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This class contains functional tests for the add like endpoint.
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class AddLikeTest {

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

  User testUser = new User("testuser", "password123", false);

  Post testPost; 

  /**
   * Set up test data before each test case.
   * This method will create a user and posts that can be used for testing likes.
   *
   * @throws Exception if there is an error during setup
   */
  @BeforeEach
  public void setup() throws Exception {
    if (!setupFlag) {
      // Setup code to create users and posts for testing likes
      userRepository.save(testUser);

      Integer catId = 1;
      Category testCategory = categoryRepository.findById((catId.longValue())).orElse(null);

      testPost = new Post(
          testUser,
          testCategory,
          "Test Post",
          "A test post",
          "123 Test Street",
          java.time.LocalDateTime.now()
      );

      postRepository.save(testPost);

      setupFlag = true;
    }
  }

  @Test
  public void testAddLike() throws Exception {
    // Test code to add a like and verify the response
    LikeRequest request = new LikeRequest();
    request.setUsername(testUser.getUsername());
    request.setPostId(testPost.getId().intValue());
    request.setStatus(true);

    Like like = null;
    String requestBody = objectMapper.writeValueAsString(request);
    mockMvc.perform(post("/v1/content/add-like")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isOk());
    try {
      like = likeRepository.findByUserIdAndPostId(testUser.getId(), testPost.getId());
      assertTrue(like != null);
    } finally {
      likeRepository.delete(like);
    }
  }

  @Test
  public void testGetLike() throws Exception {
    // Test code to get a like and verify the response
    Like like = new Like(testPost, testUser, false);
    likeRepository.save(like);

    LikeRequest request = new LikeRequest();
    request.setUsername(testUser.getUsername());
    request.setPostId(testPost.getId().intValue());

    String requestBody = objectMapper.writeValueAsString(request);
    GetLikeResponse response = objectMapper.readValue(
        mockMvc.perform(post("/v1/content/get-like")
          .contentType(MediaType.APPLICATION_JSON)
          .content(requestBody))
          .andExpect(status().isOk())
          .andReturn()
          .getResponse()
          .getContentAsString(), GetLikeResponse.class);

    try {
      assertTrue(response.getLikeStatus() == false, 
          "Expected like status to be false but got " + response.getLikeStatus());
    } finally {
      likeRepository.delete(like);
    }
  }

  @Test
  public void testGetLikeCount() throws Exception {
    // Test code to get like count and verify the response
    Like like1 = new Like(testPost, testUser, true);
    likeRepository.save(like1);

    Like like2 = new Like(testPost, testUser, true);
    likeRepository.save(like2);

    Like like3 = new Like(testPost, testUser, false);
    likeRepository.save(like3);

    FetchLikesResponse responseContent = objectMapper.readValue(
        mockMvc.perform(get("/v1/content/fetch-likes/" + testPost.getId()))
          .andExpect(status().isOk())
          .andReturn()
          .getResponse()
          .getContentAsString(), FetchLikesResponse.class);

    try {
      int likeCount = responseContent.getLikeCount();
      assertTrue(likeCount == 1, "Expected like count to be 1 but got " + likeCount);
    } finally {
      likeRepository.delete(like1);
      likeRepository.delete(like2);
      likeRepository.delete(like3);
    }
  }

}
