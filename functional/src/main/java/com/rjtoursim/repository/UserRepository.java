package com.rjtoursim.repository;

import com.rjtoursim.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for User entity.
 * Provides database operations for User objects.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  /**
  * Find a user by username.
  *
  * @param username the username to search for
  * @return an Optional containing the user if found, otherwise empty
  */
  Optional<User> findByUsername(String username);

  /**
   * Find a user by ID.
   *
   * @param id the ID of the user to search for
   * @return an Optional containing the user if found, otherwise empty
   */
  Optional<User> findById(Long id);
  
}
