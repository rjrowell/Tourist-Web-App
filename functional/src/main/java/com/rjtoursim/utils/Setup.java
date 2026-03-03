package com.rjtoursim.utils;

import com.rjtoursim.entity.Like;
import com.rjtoursim.entity.Post;
import com.rjtoursim.entity.User;
import com.rjtoursim.repository.LikeRepository;
import com.rjtoursim.repository.PostRepository;
import com.rjtoursim.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * A setup class for the prototype application.

 * Adds some demo data to the DB after Spring starts up.
 */
@Component
public class Setup implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private LikeRepository likeRepository;

  @Override
  public void run(String... args) throws Exception {
    // This runs AFTER Spring Boot starts
    
    // Create users
    User adminUser = new User("admin", "adminpwd", true);
    User regularUser = new User("user", "userpwd", false);
    
    userRepository.save(adminUser);
    userRepository.save(regularUser);
    
    // Create posts
    Post post1 = new Post(regularUser, "Portchester Castle", 
        "A medieval fortress that was developed within the walls of the Roman Saxon" 
        + " Shore fort of Portus Adurni at Portchester, to the east of Fareham in Hampshire.", 
        "Church Lane, Portchester, PO16 9QW", LocalDateTime.now());
    Post post2 = new Post(regularUser, 
        "Gunwharf Quays", 
        "A shopping centre located in the Portsea area of the city of Portsmouth in England." 
        + " it was constructed on the site of what had once been HM Gunwharf", 
        "Gunwharf Quays House, Portsmouth, PO1 3TZ", LocalDateTime.now());
    
    postRepository.save(post1);
    postRepository.save(post2);

    for (int i = 0; i <= 15; i++) {
      Like like = new Like(post1, regularUser, true);
      likeRepository.save(like);
    }

    for (int i = 0; i <= 7; i++) {
      Like like = new Like(post2, regularUser, true);
      likeRepository.save(like);
    }
    
    System.out.println("✅ Setup complete!");
  }
}