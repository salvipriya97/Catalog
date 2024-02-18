package com.emarket.catalog.product.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @Column
    String imageUrl;

    @Column
    String description;

    @Column
    BigDecimal price;

    @Column
    Integer quantity;

    @Column
    Double saleDiscount;

    @Column
    String category;



    public Product() {
    }

    public Product(Long id, String name, String imageUrl, String description, BigDecimal price, Integer quantity, Double saleDiscount, String category) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.saleDiscount = saleDiscount;
        this.category = category;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSaleDiscount() {
        return saleDiscount;
    }

    public void setSaleDiscount(Double saleDiscount) {
        this.saleDiscount = saleDiscount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
