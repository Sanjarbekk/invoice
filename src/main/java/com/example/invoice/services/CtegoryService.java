package com.example.invoice.services;

import com.example.invoice.model.Category;
import com.example.invoice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CtegoryService {
    @Autowired
    CategoryRepository repo;
    public Category save(Category category){
        return repo.save(category);
    }
    public List<Category> getAll(){
        return repo.findAll();
    }
    public Category getId(int id){
        return repo.findById(id);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
