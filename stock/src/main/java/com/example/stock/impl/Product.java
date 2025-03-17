package com.example.stock.impl;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long productId;
    private String name;
    private int stock;
    private double price;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "categoryId")
    private Category category;


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(long productId, String name, int stock, double price, Category category) {
        this.productId = productId;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }
}
