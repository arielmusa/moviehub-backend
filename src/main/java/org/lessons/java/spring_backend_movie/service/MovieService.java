package org.lessons.java.spring_backend_movie.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_backend_movie.model.Movie;
import org.lessons.java.spring_backend_movie.model.Review;
import org.lessons.java.spring_backend_movie.repository.MovieRepository;
import org.lessons.java.spring_backend_movie.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(int id){
        return movieRepository.findById(id);
    }

    public List<Movie> findByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void delete(Movie movie){
        for (Review r : movie.getReviews()) {
            reviewRepository.delete(r);
        }

        movieRepository.delete(movie);
    }
    
    public void deleteById(int id){
        Movie movie = findById(id).get();     
            for (Review r : movie.getReviews()) {
                reviewRepository.delete(r);
            }
            movieRepository.deleteById(id);
    }

}