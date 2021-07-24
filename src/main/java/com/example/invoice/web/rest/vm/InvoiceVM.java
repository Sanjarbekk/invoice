package com.example.invoice.web.rest.vm;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class InvoiceVM {

    private Long id;

    @Length(min=2,max = 8)
    private Long amount;

    @NotNull
    private LocalDate issued;

    @NotNull
    private LocalDate due;

    public InvoiceVM(Long id, Long amount, LocalDate issued, LocalDate due) {
        this.id = id;
        this.amount = amount;
        this.issued = issued;
        this.due = due;
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

    @Override
    public String toString() {
        return "InvoiceVM{" +
                "id=" + id +
                ", amount=" + amount +
                ", issued=" + issued +
                ", due=" + due +
                '}';
    }
}