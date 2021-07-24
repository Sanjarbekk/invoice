package com.example.invoice.service;

import com.example.invoice.model.Invoice;
import com.example.invoice.repository.InvoiceRepository;
import com.example.invoice.service.dto.InvoiceDTO;
import com.example.invoice.service.mapper.InvoiceMapper;
import com.example.invoice.web.rest.vm.InvoiceVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceService.class);

    private final InvoiceRepository invoiceRepository;

    private final InvoiceMapper invoiceMapper;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    /**
     * Save a invoice
     *
     * @param invoiceDTO the Entity to save
     * @return the persisted entity
     */
    @Transactional(readOnly = true)
    public InvoiceDTO save(InvoiceDTO invoiceDTO) {
        log.debug("Request to save Invoice : {}", invoiceDTO);
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(invoice);
    }

    /**
     * Get all the invoices
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<InvoiceDTO> findAll() {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAll().stream()
                .map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<InvoiceVM> findAllExpiredInvoices(LocalDate date) {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAllExpiredInvoices(date);
    }

    /**
     * Get one invoice by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public InvoiceDTO findOneDto(Long id) {
        log.debug("Request to get Invoice : {}", id);
        return invoiceRepository.findById(id)
                .map(invoiceMapper::toDto)
                .orElse(null);
    }

    /**
     * Delete the invoice by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Invoice : {}", id);
        invoiceRepository.deleteById(id);
    }
}