package com.example.invoice.web.rest;

import com.example.invoice.service.InvoiceService;
import com.example.invoice.service.dto.InvoiceDTO;
import com.example.invoice.web.rest.vm.InvoiceVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceResource {

    private final Logger log = LoggerFactory.getLogger(InvoiceResource.class);

    private final InvoiceService invoiceService;

    public InvoiceResource(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/invoice")
    ResponseEntity<InvoiceDTO> createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        log.debug("Create New Invoice : {}", invoiceDTO);
        InvoiceDTO result = invoiceService.save(invoiceDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/invoices")
    ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
        log.debug("Get All Invoices");
        List<InvoiceDTO> result = invoiceService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/invoice/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        log.debug("REST request to delete Invoice : {}", id);
        invoiceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
        log.debug("REST request to get Invoice : {}", id);
        InvoiceDTO result = invoiceService.findOneDto(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/expired_invoices")
    ResponseEntity<List<InvoiceVM>> getAllExpiredInvoices() {
        log.debug("Invoices issued after their due date");
        LocalDate date = LocalDate.now();
        List<InvoiceVM> result = invoiceService.findAllExpiredInvoices(date);
        return ResponseEntity.ok(result);
    }
}