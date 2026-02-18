package com.rjtoursim.repository;

import com.rjtoursim.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Comment entity.
 * Provides CRUD operations for comments in the database.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
  
}
