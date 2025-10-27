package org.lessons.java.spring_backend_movie.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_backend_movie.model.Movie;
import org.lessons.java.spring_backend_movie.model.Review;
import org.lessons.java.spring_backend_movie.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(int id){
        return reviewRepository.findById(id);
    }

    public Movie findReviewMovie(int id){
        return findById(id).get().getMovie();
    }

    public Review save(Review review){
        return reviewRepository.save(review);
    }

    public Review update(Review review){
        return reviewRepository.save(review);
    }

    public void delete(Review review){
        reviewRepository.delete(review);
    }

    public void deleteById(int id){
        reviewRepository.deleteById(id);
    }


}
