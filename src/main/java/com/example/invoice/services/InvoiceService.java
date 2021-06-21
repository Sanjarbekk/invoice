package com.example.invoice.services;

import com.example.invoice.model.Detail;
import com.example.invoice.model.Invoice;
import com.example.invoice.model.Order;
import com.example.invoice.repository.DetailRepository;
import com.example.invoice.repository.InvoiceRepository;
import com.example.invoice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository repo;
    @Autowired
    OrderRepository orderRepository;
    public Invoice save(Invoice invoice){
        return repo.save(invoice);
    }
    public List<Invoice> getAll(){
        return repo.findAll();
    }
    public Invoice getId(int id){
        return repo.findById(id);
    }
    public List<Invoice> getDueBetween(LocalDate start,LocalDate end){
        return repo.findAllByDueBetween(start,end);
    }
    public List<Invoice> getIssuedBetween(LocalDate start,LocalDate end){
        return repo.findAllByIssuedBetween(start,end);
    }
    public Invoice getOrderInvoice(int id){
        Order temp=orderRepository.findById(id);
        return repo.findByOrder(temp);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
