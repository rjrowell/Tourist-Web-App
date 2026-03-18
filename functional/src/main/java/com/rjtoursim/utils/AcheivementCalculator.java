package com.rjtoursim.utils;

import com.rjtoursim.entity.Like;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.LikeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This class is responsible for calculating the acheivments of a user.
 * It will contain methods to calculate different acheivments.
 */
@Component
public class AcheivementCalculator {

  @Autowired
  private LikeRepository likeRepository;

  /**
   * This method calculates the 5 likes achievement for a user.
   * It checks if the user has received 5 or more likes on their posts.
   *
   * @param user The user for whom to calculate the achievement.
   * @return true if the user has received 5 or more likes, false otherwise.
   */
  public boolean calculate5LikesAcheivement(User user) {

    List<Like> userLikes = likeRepository.findByUserId(user.getId());

    if (userLikes.size() < 5) {
      return false;
    }
    return true;
  }
}
