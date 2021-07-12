package com.example.invoice.service.dto;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class InvoiceDTO {

    private Long id;

    @Length(min=2,max = 8)
    private Long amount;

    @NotNull
    private LocalDate issued;

    @NotNull
    private LocalDate due;

    private Long orderId;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long id, Long amount, LocalDate issued, LocalDate due, Long orderId) {
        this.id = id;
        this.amount = amount;
        this.issued = issued;
        this.due = due;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getIssued() {
        return issued;
    }

    public void setIssued(LocalDate issued) {
        this.issued = issued;
    }

    public LocalDate getDue() {
        return due;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", issued=" + issued +
                ", due=" + due +
                ", orderId=" + orderId +
                '}';
    }
}