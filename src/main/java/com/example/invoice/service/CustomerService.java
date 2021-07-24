package com.example.invoice.service;

import com.example.invoice.model.Customer;
import com.example.invoice.repository.CustomerRepository;
import com.example.invoice.service.dto.CustomerDTO;
import com.example.invoice.service.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    /**
     * Save a customer
     *
     * @param customerDTO the Entity to save
     * @return the persisted entity
     */
    @Transactional(readOnly = true)
    public CustomerDTO save(CustomerDTO customerDTO) {
        log.debug("Request to save Bank : {}", customerDTO);
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    /**
     * Get all the customers
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll() {
        log.debug("Request to get all Customers");
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Get one bank by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public CustomerDTO findOneDto(Long id) {
        log.debug("Request to get Bank : {}", id);
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElse(null);
    }

    /**
     * Delete the customer by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }
}
