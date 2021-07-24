package com.example.invoice.service.mapper;

import com.example.invoice.model.Payment;
import com.example.invoice.service.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InvoiceMapper.class})
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {

    @Mapping(source = "invoice.id", target = "invoiceId")
    PaymentDTO toDto(Payment payment);

    @Mapping(source = "invoiceId", target = "invoice")
    Payment toEntity(PaymentDTO PaymentDTO);

    default Payment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Payment payment = new Payment();
        payment.setId(id);
        return payment;
    }
}
