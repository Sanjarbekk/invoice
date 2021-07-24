package com.example.invoice.service.dto;

import javax.validation.constraints.NotNull;

public class DetailFeedDTO {

    private Long id;

    @NotNull
    private short quantity;

    public DetailFeedDTO() {
    }

    public DetailFeedDTO(Long id, short quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DetailVM{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}