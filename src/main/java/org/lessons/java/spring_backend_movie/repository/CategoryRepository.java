package org.lessons.java.spring_backend_movie.repository;

import org.lessons.java.spring_backend_movie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>  {
    
}
