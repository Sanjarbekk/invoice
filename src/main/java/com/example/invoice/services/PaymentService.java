package com.example.invoice.services;

import com.example.invoice.model.Invoice;
import com.example.invoice.model.Order;
import com.example.invoice.model.Payment;
import com.example.invoice.repository.InvoiceRepository;
import com.example.invoice.repository.OrderRepository;
import com.example.invoice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class PaymentService {
    @Autowired
    InvoiceRepository repository;
    @Autowired
    PaymentRepository repo;
    public Payment save(Payment payment){
        return repo.save(payment);
    }
    public List<Payment> getAll(){
        return repo.findAll();
    }
    public Payment getId(int id){
        return repo.findById(id);
    }
    public List<Payment> getTimeBetween(LocalDate start, LocalDate end){
        return repo.findAllByTimeBetween(start,end);
    }

    public List<Payment> getPaymentInvoice(int id){
        Invoice temp=repository.findById(id);
        return repo.findAllByInvoice(temp);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
