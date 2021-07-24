package com.example.invoice.web.rest;

import com.example.invoice.service.CustomerService;
import com.example.invoice.service.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {
    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        log.debug("Create New Customer : {}", customerDTO);
        CustomerDTO result = customerService.save(customerDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/customers")
    ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.debug("Get All Customers");
        List<CustomerDTO> result = customerService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        log.debug("REST request to delete Customer : {}", id);
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        log.debug("REST request to get Customer : {}", id);
        CustomerDTO result = customerService.findOneDto(id);
        return ResponseEntity.ok(result);
    }
}