package com.example.invoice.repository;

import com.example.invoice.model.Category;
import com.example.invoice.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Override
    List<Product> findAll();

    @Override
    List<Product> findAll(Sort sort);

    Product findById(int id);
    Product findByName(String name);
    List<Product> findAllByCategory(Category category);


}
