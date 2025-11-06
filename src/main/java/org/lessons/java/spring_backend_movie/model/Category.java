package org.lessons.java.spring_backend_movie.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

// should be genre but its ugly :)
@Entity
@Table(name = "categories")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank (message = "Category name can't be blank")
    @Max(value = 10)
    private String name;

    @Lob
    private String description;

    @ManyToMany (mappedBy = "categories")
    private List<Movie> movie;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Movie> getMovie() {
        return this.movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

}
