package com.example.invoice.repository;

import com.example.invoice.model.Invoice;
import com.example.invoice.model.Payment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Override
    List<Payment> findAll();
    List<Payment> findAllByTimeBetween(LocalDate start, LocalDate end);
    List<Payment> findAllByInvoice(Invoice invoice);

    Payment findById(int id);

    void deleteById(int id);
}
