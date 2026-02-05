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

/**
 * This class represents the Like entity in the DB.
 */
@Entity
@Table(name = "likes")
public class Like {
  
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

  @Column(name = "like_status", nullable = false)
  private boolean likeStatus;

  /**
   * Convenience constructer for the Like object.
   *
   * @param post 
   *       -The Post object that this like is tied to
   * 
   * @param user
   *        -The User object this like is tied to
   * 
   * @param likeStatus
   *        -The like status for this like
   */
  public Like(Post post, User user, boolean likeStatus) {
    this.post = post;
    this.user = user;
    this.likeStatus = likeStatus;
  }
}
