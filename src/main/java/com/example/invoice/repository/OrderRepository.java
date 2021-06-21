package com.example.invoice.repository;

import com.example.invoice.model.Customer;
import com.example.invoice.model.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Override
    List<Order> findAll();
    List<Order> findAllByDateBetween(LocalDate start, LocalDate end);
    List<Order> findAllByCustomer(Customer customer);

    Order findById(int id);
    void deleteById(int id);
}
