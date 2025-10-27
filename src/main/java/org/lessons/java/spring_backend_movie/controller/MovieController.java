package org.lessons.java.spring_backend_movie.controller;

import org.lessons.java.spring_backend_movie.model.Movie;
import org.lessons.java.spring_backend_movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "movies/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("movie", movieService.findById(id).get());
        return "movies/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "movies/create";
        
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("movie", movieService.findById(id).get());
        return "movies/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasErrors()) return "movies/edit";
        
        movieService.saveMovie(movie);
        return "redirect:/movies/" + id;
    }
    
    @PostMapping("/{id}/delete")
    public String destroy(@PathVariable int id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }
    
    
    

    
    
}
