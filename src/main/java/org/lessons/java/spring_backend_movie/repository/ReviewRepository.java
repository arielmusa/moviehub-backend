package org.lessons.java.spring_backend_movie.repository;

import org.lessons.java.spring_backend_movie.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
