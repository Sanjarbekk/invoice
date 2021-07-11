package com.example.invoice.service.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PaymentDTO {

    private Long id;

    @NotNull
    private LocalDate time;

    @Length(min = 2, max = 8)
    private Long amount;

    private Long invoiceId;

    public PaymentDTO() {
    }

    public PaymentDTO(Long id, LocalDate time, Long amount, Long invoiceId) {
        this.id = id;
        this.time = time;
        this.amount = amount;
        this.invoiceId = invoiceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", time=" + time +
                ", amount=" + amount +
                ", invoiceId=" + invoiceId +
                '}';
    }
}