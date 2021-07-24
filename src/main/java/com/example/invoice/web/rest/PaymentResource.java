package com.example.invoice.web.rest;

import com.example.invoice.service.PaymentService;
import com.example.invoice.service.dto.PaymentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentResource {

    private final Logger log = LoggerFactory.getLogger(PaymentResource.class);

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    ResponseEntity<PaymentDTO> createPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
        log.debug("Create New Payment : {}", paymentDTO);
        PaymentDTO result = paymentService.save(paymentDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/payments")
    ResponseEntity<List<PaymentDTO>> getAllPayments() {
        log.debug("Get All Payments");
        List<PaymentDTO> result = paymentService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        log.debug("REST request to delete Payment : {}", id);
        paymentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        log.debug("REST request to get Payment : {}", id);
        PaymentDTO result = paymentService.findOneDto(id);
        return ResponseEntity.ok(result);
    }
}