package org.lessons.java.spring_backend_movie.controller;

import org.lessons.java.spring_backend_movie.model.Review;
import org.lessons.java.spring_backend_movie.service.ReviewService;
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
@RequestMapping("/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String index() {
        reviewService.findAll();
        return "reviews/index";
    }

/*     @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("review", new Review());
        return "reviews/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("review") Review review, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "reviews/create";

        reviewService.save(review);
        return "redirect:/reviews";
    } */

    @PostMapping("/{id}/delete")
    public String destroy(@PathVariable int id) {
        int movieId = reviewService.findReviewMovie(id).getId();
        reviewService.deleteById(id);
        
        return "redirect:/movies/" + movieId;
    }
    
    
    
    
}
