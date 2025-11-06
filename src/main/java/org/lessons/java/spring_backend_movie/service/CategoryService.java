package org.lessons.java.spring_backend_movie.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.lessons.java.spring_backend_movie.model.Category;
import org.lessons.java.spring_backend_movie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public Set<Category> findAll(){

        Set<Category> s = new HashSet<>();
        s.addAll(categoryRepository.findAll());
        
        return  s;
    }

    public Optional<Category> findById(int id){
        return categoryRepository.findById(id);
    }

    public Category store(Category c){
        return categoryRepository.save(c);
    }

    public Category update(Category c){
        return categoryRepository.save(c);
    }

    public void delete(Category c){
        categoryRepository.delete(c);
    }

    public void deleteById(int id){
        categoryRepository.deleteById(id);
    }

}
