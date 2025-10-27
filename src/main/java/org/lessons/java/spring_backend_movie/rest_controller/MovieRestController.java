package org.lessons.java.spring_backend_movie.rest_controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_backend_movie.model.Movie;
import org.lessons.java.spring_backend_movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> index() {
        List<Movie> movies =  movieService.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> show(@PathVariable int id) {
        Optional<Movie> m = movieService.findById(id);

        if (m.isEmpty()) return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Movie>(m.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> store(@RequestBody Movie movie) {        
        return new ResponseEntity<Movie>(movieService.create(movie), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable int id, @RequestBody Movie movie) {        
        return new ResponseEntity<Movie>(movieService.update(movie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable int id){
        movieService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    
}
