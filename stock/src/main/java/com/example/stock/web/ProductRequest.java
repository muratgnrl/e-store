package com.example.stock.web;

import com.example.stock.api.CategoryDto;
import com.example.stock.api.ProductDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    private String name;
    private int stock;
    private double price;
    private String categoryId;

    public ProductDto toDto() {
        ProductDto productDto = new ProductDto();
        productDto.setName(this.name);
        productDto.setStock(this.stock);
        productDto.setPrice(this.price);


        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(Long.valueOf(this.categoryId));
        productDto.setCategoryDto(categoryDto);

        return productDto;
    }

}
