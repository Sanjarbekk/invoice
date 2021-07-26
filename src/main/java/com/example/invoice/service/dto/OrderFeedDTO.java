package com.example.invoice.service.dto;

public class OrderFeedDTO {

    private String status;

    private Long createdInvoiceId;

    public OrderFeedDTO() {
    }

    public OrderFeedDTO(String status, Long createdInvoiceId) {
        this.status = status;
        this.createdInvoiceId = createdInvoiceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedInvoiceId() {
        return createdInvoiceId;
    }

    public void setCreatedInvoiceId(Long createdInvoiceId) {
        this.createdInvoiceId = createdInvoiceId;
    }

    @Override
    public String toString() {
        return "OrderFeedDTO{" +
                "status='" + status + '\'' +
                ", createdInvoiceId=" + createdInvoiceId +
                '}';
    }
}