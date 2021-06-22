package com.example.invoice.service;

import com.example.invoice.service.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService{

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }


}
