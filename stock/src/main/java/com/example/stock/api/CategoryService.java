package com.example.stock.api;

import com.example.stock.impl.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {


    CategoryDto save(CategoryDto dto);

    CategoryDto getCategory(String id);

    List<CategoryDto> getAllCategory();

    CategoryDto update(CategoryDto dto, String id);

    void delete(String id);

    Category getCategoryEntity(String id);
}
