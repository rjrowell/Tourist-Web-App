package com.rjtoursim.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The entity represents the post table in the DB.
 */
@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  //Foreign key to user table
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "title", nullable = false, length = 255)
  private String title;

  @Column(name = "description", nullable = false, length = 255)
  private String description;

  @Column(name = "address", nullable = false, length = 255)
  private String address;

  @Column(name = "date_posted", nullable = false)
  private LocalDateTime datePosted;

  //One post can have many likes
  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Like> likes = new ArrayList<>();

  //One post can have many comments
  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Like> comments = new ArrayList<>();

  /**
   * Conveniance constructer for Post class.
   *
   * @param user
   *          - the user that created the post
   *
   * @param title
   *          - the title of the tourism post
   *
   * @param desc
   *          - the description of the tourism post.
   *
   * @param address
   *          - the address of the tourist location.
   *
   * @param datePosted
   *          - the date the post was posted to the site.
   */
  public Post(User user, String title, String desc, String address, LocalDateTime datePosted) {
    this.user = user;
    this.title = title;
    this.description = desc;
    this.address = address;
    this.datePosted = datePosted;
  }
}
