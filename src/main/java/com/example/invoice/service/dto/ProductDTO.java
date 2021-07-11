package com.example.invoice.service.dto;

import org.hibernate.validator.constraints.Length;

public class ProductDTO {

    private Long id;

    @Length(max = 10)
    private String name;

    @Length(max = 20)
    private String description;

    @Length(min = 2, max = 6)
    private short price;

    @Length(max=1024)
    private String photo;

    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, short price, String photo, Long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}