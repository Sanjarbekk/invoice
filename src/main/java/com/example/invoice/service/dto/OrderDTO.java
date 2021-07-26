package com.example.invoice.service.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class OrderDTO {

    private Long id;

    @NotNull
    private LocalDate date;

    private Long customerId;

    public OrderDTO() {
    }

    public OrderDTO(Long id, LocalDate date, Long customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public OrderDTO(LocalDate date, Long customerId) {
        this.date = date;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", date=" + date +
                ", customerId=" + customerId +
                '}';
    }
}