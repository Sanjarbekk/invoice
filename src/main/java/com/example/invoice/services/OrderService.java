package com.example.invoice.services;

import com.example.invoice.model.Customer;
import com.example.invoice.model.Invoice;
import com.example.invoice.model.Order;
import com.example.invoice.repository.CustomerRepository;
import com.example.invoice.repository.InvoiceRepository;
import com.example.invoice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    CustomerRepository repository;
    @Autowired
    OrderRepository repo;
    public Order save(Order order){
        return repo.save(order);
    }
    public List<Order> getAll(){
        return repo.findAll();
    }
    public Order getId(int id){
        return repo.findById(id);
    }
    public List<Order> getDateBetween(LocalDate start, LocalDate end){
        return repo.findAllByDateBetween(start,end);
    }
    public List<Order> getCustomerOrder(int id){
        Customer temp =repository.findById(id);
        return repo.findAllByCustomer(temp);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
