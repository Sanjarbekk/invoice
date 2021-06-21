package com.example.invoice.repository;

import com.example.invoice.model.Customer;
import com.example.invoice.model.Detail;
import com.example.invoice.model.Order;
import com.example.invoice.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    @Override
    List<Detail> findAll();

    @Override
    List<Detail> findAll(Sort sort);

    Detail findById(int id);
    Detail findByOrder(Order order);
    Detail findByProduct(Product product);


    void deleteById(int id);
}
