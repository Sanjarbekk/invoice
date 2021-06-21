package com.example.invoice.services;

import com.example.invoice.model.Customer;
import com.example.invoice.model.Detail;
import com.example.invoice.model.Order;
import com.example.invoice.repository.CustomerRepository;
import com.example.invoice.repository.DetailRepository;
import com.example.invoice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {
    @Autowired
    DetailRepository repo;
    @Autowired
    OrderRepository orderRepository;
    public Detail save(Detail detail){
        return repo.save(detail);
    }
    public List<Detail> getAll(){
        return repo.findAll();
    }
    public Detail getId(int id){
        return repo.findById(id);
    }
    public Detail getOrderDetail(int id){
        Order temp=orderRepository.findById(id);
        return repo.findByOrder(temp);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
