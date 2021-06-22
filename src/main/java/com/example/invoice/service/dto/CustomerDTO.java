package com.example.invoice.service.dto;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

public class CustomerDTO {

    private Long id;

    @NotNull
    @Length(max = 14)
    private String name;

    @NotNull
    @Length(max = 3)
    private String country;

    private String address;

    @Length(max = 50)
    private String phone;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name,  String country, String address, String phone) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phone = phone;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
