package com.example.invoice.service.dto;

import javax.validation.constraints.NotNull;

public class DetailDTO {

    private Long id;

    @NotNull
    private short quantity;

    private Long productId;

    private Long orderId;

    public DetailDTO() {
    }

    public DetailDTO(Long id, short quantity, Long productId, Long orderId) {
        this.id = id;
        this.quantity = quantity;
        this.productId = productId;
        this.orderId = orderId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "DetailDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", orderId=" + orderId +
                '}';
    }
}
