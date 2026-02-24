package com.rjtourism;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.rjtoursim.Application;
import com.rjtoursim.entity.Comment;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.CommentRepository;
import com.rjtoursim.repository.PostRepository;
import com.rjtoursim.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This class contains functional tests for content moderation features.
 */

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
@Rollback(true)
public class ContentModerationTest {

  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;
  
  private boolean setupFlag = false;

  /**
   * Set up test data before each test case. 
   * This method will create a user that can be used for testing content moderation features.
   */
  @BeforeEach
  public void setup() {
    if (!setupFlag) {
      User user = new User("testuser", "testPassword123", false);
      userRepository.save(user);
      setupFlag = true;
    }
  }

  @Test
  public void testPostRemoval() throws Exception {
    Post testPost = createTestPost();
    mockMvc.perform(delete("/v1/content/delete-post/" + testPost.getId()))
        .andExpect(status().isOk());

    // Verify that the post has been removed from the database
    try {
      assertTrue(postRepository.findById(testPost.getId()).isEmpty());
    } finally {
      postRepository.delete(testPost);
    }
  }

  @Test
  public void testCommentRemoval() throws Exception {
    Post testPost = createTestPost();
    Comment testComment = new Comment(
        testPost, 
        userRepository.findByUsername("testuser").orElseThrow(), 
        "This is an inappropriate comment.", 
        LocalDateTime.now()
    );
    commentRepository.save(testComment);

    mockMvc.perform(delete("/v1/content/delete-comment/" + testComment.getId()))
          .andExpect(status().isOk());
    try {
      // Verify that the comment has been removed from the database
      assertTrue(commentRepository.findById(testComment.getId()).isEmpty());
    } finally {
      commentRepository.delete(testComment);
    }
  }

  /**
   * Helper method to create a test post with inappropriate content for testing purposes.

   * @return the created Post object
   */
  public Post createTestPost() {
    Post testPost = new Post(
          userRepository.findByUsername("testuser").orElseThrow(), 
          "Inappropriate Content", "This post contains inappropriate content.", 
          "123 Test Street", 
          LocalDateTime.now()
        );
    postRepository.save(testPost);
    return testPost;
  }
}
