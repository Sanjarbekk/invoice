package com.example.invoice.repository;

import com.example.invoice.model.Category;
import com.example.invoice.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();

    @Override
    List<Customer> findAll(Sort sort);

    Customer findById(int id);
    Customer findByName(String name);

    void deleteById(int id);
}
