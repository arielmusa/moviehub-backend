package org.lessons.java.spring_backend_movie.repository;

import java.util.List;

import org.lessons.java.spring_backend_movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public List<Movie> findByTitleContainingIgnoreCase(String title);
}
