package com.rjtoursim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * This entity represents the comment table in the DB.
 */
@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  //Foreign Key for Post id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  //Foreign Key for User id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "text", nullable = false, length = 255)
  private String text;

  @Column(name = "date_posted", nullable = false)
  private LocalDateTime datePosted;

  /**
   * Constructs a Comment with the specified post, user, text, and date posted.
   *
   * @param post 
   *          - the post associated with this comment
   * @param user 
   *          - the user who created this comment
   * @param text 
   *          - the content of the comment
   * @param datePosted 
   *          - the date and time when the comment was posted
   */
  public Comment(Post post, User user, String text, LocalDateTime datePosted) {
    this.post = post;
    this.user = user;
    this.text = text;
    this.datePosted = datePosted;
  }

  //Getters
  public Long getId() {
    return id;
  }
}
