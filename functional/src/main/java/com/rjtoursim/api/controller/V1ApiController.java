package com.rjtoursim.api.controller;

import com.rjtoursim.api.model.CalculateAchievementResponse;
import com.rjtoursim.api.model.CategoryResponse;
import com.rjtoursim.api.model.CreatePostRequest;
import com.rjtoursim.api.model.FetchLikesResponse;
import com.rjtoursim.api.model.FetchPostsResponse;
import com.rjtoursim.api.model.GetLikeResponse;
import com.rjtoursim.api.model.LikeRequest;
import com.rjtoursim.api.model.PostDTO;
import com.rjtoursim.api.model.UserCredentials;
import com.rjtoursim.entity.Category;
import com.rjtoursim.entity.Comment;
import com.rjtoursim.entity.Like;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.CategoryRepository;
import com.rjtoursim.repository.CommentRepository;
import com.rjtoursim.repository.LikeRepository;
import com.rjtoursim.repository.PostRepository;
import com.rjtoursim.repository.UserRepository;
import com.rjtoursim.utils.AcheivementCalculator;
import java.util.List;
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

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private LikeRepository likeRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private AcheivementCalculator achievementCalculator;

  @Override
  public ResponseEntity<Void> createUser(UserCredentials createUserRequest) {

    //Check if the username is already taken, if so return a 409 Conflict status code
    if (userRepository.findByUsername(createUserRequest.getUsername()).isPresent()) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    User user = new User(createUserRequest.getUsername(),
        createUserRequest.getHashedPassword(),
        createUserRequest.getIsAdmin());
    userRepository.save(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<CalculateAchievementResponse> calculateAchievement(Integer userId) {

    User user = userRepository.findById(userId.longValue()).orElse(null);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    CalculateAchievementResponse response = new CalculateAchievementResponse();

    if (achievementCalculator.calculate5LikesAcheivement(userId)) {
      response.setFiveLikesAchievement(true);
    } else {
      response.setFiveLikesAchievement(false);
    }

    return new ResponseEntity<>(response, HttpStatus.OK);
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
    Category category = categoryRepository.findById(
        createPostRequest.getCategoryId().longValue()).orElse(null);
    //Check we find the user, if not return a 400 Bad Request status code. 
    // If the user already has a post with the same title, return a 409 Conflict status code
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else if (postRepository.existsByUserAndTitle(user, createPostRequest.getTitle())) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } 

    Post newPost = new Post(
        user,
        category,
        createPostRequest.getTitle(), 
        createPostRequest.getDescription(), 
        createPostRequest.getAddress(), 
        createPostRequest.getDatePosted().toLocalDateTime()
      );
    
    postRepository.save(newPost);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<FetchPostsResponse> fetchPosts() {
    FetchPostsResponse response = new FetchPostsResponse();
    List<Post> posts = postRepository.findAll();

    if (!posts.isEmpty()) {
      for (Post post : posts) {
        PostDTO postItem = new PostDTO();
        postItem.setId(post.getId().intValue());
        postItem.setCategoryId(post.getCategory().getId().intValue());
        postItem.setUsername(post.getUser().getUsername());
        postItem.setTitle(post.getTitle());
        postItem.setDescription(post.getDescription());
        postItem.setAddress(post.getAddress());
        postItem.setDatePosted(post.getDatePosted().atOffset(java.time.ZoneOffset.UTC));
        response.addPostsItem(postItem);
      }
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<FetchPostsResponse> fetchPostsByCategory(Integer catId) {
    FetchPostsResponse response = new FetchPostsResponse();
    List<Post> posts = postRepository.findByCategory(
          categoryRepository.findById(catId.longValue()).orElse(null));

    if (!posts.isEmpty()) {
      for (Post post : posts) {
        PostDTO postItem = new PostDTO();
        postItem.setId(post.getId().intValue());
        postItem.setCategoryId(post.getCategory().getId().intValue());
        postItem.setUsername(post.getUser().getUsername());
        postItem.setTitle(post.getTitle());
        postItem.setDescription(post.getDescription());
        postItem.setAddress(post.getAddress());
        postItem.setDatePosted(post.getDatePosted().atOffset(java.time.ZoneOffset.UTC));
        response.addPostsItem(postItem);
      }
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deletePost(Integer postId) {
    Post post = postRepository.findById(postId.longValue()).orElse(null);
    if (post == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    postRepository.delete(post);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteComment(Integer commentId) {
    Comment comment = commentRepository.findById(commentId.longValue()).orElse(null);
    if (comment == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    commentRepository.delete(comment);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> addLike(LikeRequest likeRequest) {
    User user = userRepository.findById(likeRequest.getUserId().longValue()).orElse(null);
    Post post = postRepository.findById(likeRequest.getPostId().longValue()).orElse(null);

    if (user == null || post == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Like checkLike = likeRepository.findByUserIdAndPostId(user.getId(), post.getId());
    if (checkLike != null) {
      checkLike.setStatus(likeRequest.getStatus());
      likeRepository.save(checkLike);
    } else {
      Like newLike = new Like(post, user, likeRequest.getStatus());
      likeRepository.save(newLike);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<GetLikeResponse> getLike(LikeRequest likeRequest) {
    User user = userRepository.findById(likeRequest.getUserId().longValue()).orElse(null);
    Post post = postRepository.findById(likeRequest.getPostId().longValue()).orElse(null);

    if (user == null || post == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Like like = likeRepository.findByUserIdAndPostId(user.getId(), post.getId());
    if (like == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    GetLikeResponse response = new GetLikeResponse();
    response.setLikeStatus(like.getStatus());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<FetchLikesResponse> fetchLikes(Integer postId) {
    Post post = postRepository.findById(postId.longValue()).orElse(null);
    if (post == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    List<Like> likes = likeRepository.findByPostId(post.getId());
    int likeCount = 0;
    for (Like like : likes) {
      if (like.getStatus()) {
        likeCount++;
      } else {
        likeCount--;
      }
    }

    FetchLikesResponse response = new FetchLikesResponse();
    response.setLikeCount(likeCount);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CategoryResponse> getCategory(Integer catId) {
    Category category = categoryRepository.findById(catId.longValue()).orElse(null);
    if (category.equals(null)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    CategoryResponse response = new CategoryResponse();
    response.setCategoryName(category.getName());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}