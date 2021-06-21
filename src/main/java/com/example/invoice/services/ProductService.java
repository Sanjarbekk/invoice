package com.example.invoice.services;

import com.example.invoice.model.Category;
import com.example.invoice.model.Invoice;
import com.example.invoice.model.Order;
import com.example.invoice.model.Product;
import com.example.invoice.repository.CategoryRepository;
import com.example.invoice.repository.InvoiceRepository;
import com.example.invoice.repository.OrderRepository;
import com.example.invoice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    @Autowired
    CategoryRepository repository;
    public Product save(Product product){
        return repo.save(product);
    }
    public List<Product> getAll(){
        return repo.findAll();
    }
    public Product getId(int id){
        return repo.findById(id);
    }
    public Product getName(String name){
        return repo.findByName(name);
    }

    public List<Product> getProductCategory(int id){
        Category temp=repository.findById(id);
        return repo.findAllByCategory(temp);
    }
    public void deleteById(int id){
        repo.deleteById(id);
    }
}
