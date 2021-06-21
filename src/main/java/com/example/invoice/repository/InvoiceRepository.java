package com.example.invoice.repository;

import com.example.invoice.model.Detail;
import com.example.invoice.model.Invoice;
import com.example.invoice.model.Order;
import com.example.invoice.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Override
    List<Invoice> findAll();

    @Override
    List<Invoice> findAll(Sort sort);

    Invoice findById(int id);
    Invoice findByOrder(Order order);

    List<Invoice> findAllByIssuedBetween(LocalDate start, LocalDate end);

    List<Invoice> findAllByDueBetween(LocalDate start, LocalDate end);

    void deleteById(int id);
}
