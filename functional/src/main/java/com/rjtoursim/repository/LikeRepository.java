package com.rjtoursim.repository;

import com.rjtoursim.entity.Like;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Like entity.
 * Provides CRUD operations for likes in the database.
 */
public interface LikeRepository extends JpaRepository<Like, Long> {
  
  /**
   * Find a like by user ID and post ID. 
   * This method will be used to check if a user has already liked a specific post.
   * Spring Data JPA will automatically implement this method.

   * @param userId The user ID of the like to find.

   * @param postId The post ID of the like to find.

   * @return The Like entity if found.
   */
  Like findByUserIdAndPostId(Long userId, Long postId);

  List<Like> findByPostId(Long postId);
}
