package com.rjtoursim.repository;

import com.rjtoursim.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A CRUD repository for the Category entity.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
  
}
