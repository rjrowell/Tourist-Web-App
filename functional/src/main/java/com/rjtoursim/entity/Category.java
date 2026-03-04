package com.rjtoursim.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


/**
 * An entity representing the category table of the data base.
 */
@Entity
@Table(name = "categories")
public class Category {

  @Id
  private Long id;
  
  @Column(nullable = false, unique = true, length = 100)
  private String name;
  
  // One category has many posts
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Post> posts = new ArrayList<>();
  
  // Constructors
  public Category() {}
  
  public Category(long id, String name) {
    this.id = id;
    this.name = name;
  }
  
  // Getters and Setters
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public List<Post> getPosts() {
    return posts;
  }
  
  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}