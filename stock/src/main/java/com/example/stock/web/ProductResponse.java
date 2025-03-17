package com.example.stock.web;

import com.example.stock.api.CategoryDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Long productId;
    private String name;
    private int stock;
    private double price;
    private CategoryDto categoryDto;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public ProductResponse() {
    }

    public ProductResponse(Long productId, String name, int stock, double price, CategoryDto categoryDto) {
        this.productId = productId;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.categoryDto = categoryDto;
    }
}
