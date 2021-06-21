package com.example.invoice.services;

import com.example.invoice.model.Category;
import com.example.invoice.model.Customer;
import com.example.invoice.repository.CategoryRepository;
import com.example.invoice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    CustomerRepository repo;
    public Customer save(Customer customer){
        return repo.save(customer);
    }
    public List<Customer> getAll(){
        return repo.findAll();
    }
    public Customer getId(int id){
        return repo.findById(id);
    }
    public Customer getName(String name){
        return repo.findByName(name);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
