package org.lessons.java.spring_backend_movie.rest_controller;

import org.lessons.java.spring_backend_movie.model.Review;
import org.lessons.java.spring_backend_movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController {
    
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> store(@RequestBody Review review) {
        reviewService.save(review);
        
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable int id){
        reviewService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
