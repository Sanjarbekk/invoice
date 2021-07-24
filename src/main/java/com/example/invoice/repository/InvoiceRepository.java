package com.example.invoice.repository;

import com.example.invoice.model.Invoice;
import com.example.invoice.web.rest.vm.InvoiceVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query(
            "Select new com.example.invoice.web.rest.vm.InvoiceVM( " +
                    "i.id, i.amount, i.issued, i.due " +
                    ") " +
                    "from Invoice i " +
                    "where i.due < :expDate "
    )
    List<InvoiceVM> findAllExpiredInvoices(@Param("expDate") LocalDate expDate);
}