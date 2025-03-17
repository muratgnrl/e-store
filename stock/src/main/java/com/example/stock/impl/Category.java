package com.example.stock.impl;

import jakarta.persistence.*;
import lombok.Builder;

@Table(name = "categories")
@Entity
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long categoryId;
    private String name;

    public Category() {
    }

    public Category(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
