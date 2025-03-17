package com.example.stock.impl;

import com.example.stock.api.CategoryDto;
import com.example.stock.api.CategoryService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        Category category =toEntity(dto);
        category=repository.save(category);
        return toDto(category);
    }

    @Override
    public CategoryDto getCategory(String id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto dto, String id) {

        Category category=repository.findById(Long.valueOf(id)).get();
        category.setName(dto.getName());
        category=repository.save(category);

        return toDto(category);
    }

    @Override
    public void delete(String id) {
        Category category =repository.findById(Long.valueOf(id)).get();
        repository.delete(category);
    }

    @Override
    public Category getCategoryEntity(String id) {
        Category category = repository.findById(Long.valueOf(id)).get();
        return category;
    }


    public CategoryDto toDto(Category entity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(entity.getCategoryId());
        categoryDto.setName(entity.getName());
        return categoryDto;
    }

    Category toEntity(CategoryDto categoryDto){
        Category category =new Category();
        category.setName(categoryDto.getName());
        return category;
    }
}
