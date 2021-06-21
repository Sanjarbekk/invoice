package com.example.invoice.repository;

import com.example.invoice.model.Category;
import com.example.invoice.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Override
    List<Category> findAll();

    @Override
    List<Category> findAll(Sort sort);

    Category findById(int id);
    Category findByName(String name);



}
