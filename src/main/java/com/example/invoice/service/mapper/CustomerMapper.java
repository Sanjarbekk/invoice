package com.example.invoice.service.mapper;

import com.example.invoice.model.Customer;
import com.example.invoice.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {

}
