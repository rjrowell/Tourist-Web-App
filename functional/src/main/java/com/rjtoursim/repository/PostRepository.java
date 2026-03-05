package com.rjtoursim.repository;

import com.rjtoursim.entity.Category;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Post entity.
 * Provides CRUD operations and a convenience method to check for an
 * existing post by a specific user with a given title.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  /**
   * Determine whether a post already exists for a user with the specified title.
   * Spring Data JPA will automatically implement this method based on the
   * naming convention.  The generated query will look for a record in the
   * {@code posts} table where the {@code user_id} column matches the passed
   * {@link User} and the {@code title} column matches the provided string.
   *
   * @param user  the owner of the post
   * @param title the title to check for
   * @return {@code true} if a matching post exists, {@code false} otherwise
   */
  boolean existsByUserAndTitle(User user, String title);

  List<Post> findByCategory(Category category);
}
