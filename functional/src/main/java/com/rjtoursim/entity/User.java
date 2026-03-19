package com.rjtoursim.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * This entity represents the user table in the DB.
 */
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", nullable = false, length = 16)
  private String username;

  @Column(name = "password", nullable = false, length = 255)
  private String password;

  @Column(name = "is_admin", nullable = false)
  private boolean isAdmin;

  //One user can have many posts
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts = new ArrayList<>();

  //One user can post many likes
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Like> likes = new ArrayList<>();

  //One user can post many comments
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Like> comments = new ArrayList<>();

  /**
  * Conveniance constructor.
  */
  public User(String username, String password, boolean isAdmin) {
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  /**
   * Default constructor.
   */
  public User() {

  }

  //Getters and setters

  public Long getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public boolean getIsAdmin() {
    return this.isAdmin;
  }
}