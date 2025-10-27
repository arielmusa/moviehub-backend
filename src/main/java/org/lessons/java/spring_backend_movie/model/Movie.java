package org.lessons.java.spring_backend_movie.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @NotBlank(message = "Movie title is mandatory")
    private String title;

    @NotBlank(message = "Movie director is mandatory")
    private String director;

    @NotBlank(message = "Movie genre is mandatory")
    private String genre;

    @Min(value = 1900)
    @NotNull(message = "Movie release year is mandandatory")
    private int release_year;

    @Lob
    @NotBlank(message = "Movie description is mandatory")
    private String description;

    @NotBlank(message = "Movie image is mandatory")
    private String image;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp created_at;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updated_at;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public int getRelease_year() {
        return this.release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }


    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }



}
