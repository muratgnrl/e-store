package com.example.stock.web;

import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class CategoryResponse {

    private final Long categoryId;
    private final String name;

    // Constructor
    public CategoryResponse(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    // Getter for categoryId
    public Long getCategoryId() {
        return categoryId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // No setter methods because fields are final
}


