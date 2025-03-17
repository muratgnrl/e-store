package com.example.stock.web;

import com.example.stock.api.CategoryDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryRequest {

    private String name;

    public CategoryRequest(@JsonProperty("name") String name){
        this.name=name;
    }

    public CategoryDto toDto() {
        // Manuel olarak CategoryDto nesnesi oluşturuluyor
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(this.name);
        return categoryDto;
    }

}
