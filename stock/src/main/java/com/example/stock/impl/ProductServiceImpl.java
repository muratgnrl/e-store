package com.example.stock.impl;

import com.example.stock.api.CategoryDto;
import com.example.stock.api.CategoryService;
import com.example.stock.api.ProductDto;
import com.example.stock.api.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        Product product = toEntity(dto);
        product=repository.save(product);
        return toDto(product);
    }

    @Override
    public ProductDto getProduct(String id) {
        Product product =repository.findById(Long.valueOf(id)).get();
        return toDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return repository.findAll().stream()
                .map(product -> toDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(ProductDto dto, String id) {

        Product product = repository.findById(Long.valueOf(id)).get();
        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        product.setCategory(categoryService.getCategoryEntity(String.valueOf(dto.getCategoryDto().getCategoryId())));

        product = repository.save(product);

        return toDto(product);
    }

    @Override
    public void delete(String id) {
        Product product =repository.findById(Long.valueOf(id)).get();
        repository.delete(product);
    }

    public Product toEntity(ProductDto productDto){
        Product product =new Product();
        product.setName(product.getName());
        product.setStock(product.getStock());
        product.setPrice(product.getPrice());
        product.setCategory(categoryService.getCategoryEntity(String.valueOf(productDto.getCategoryDto())));
        return product;
    }



    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());

        // CategoryDto'yu manuel olarak oluşturuyoruz
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(product.getCategory().getCategoryId());
        categoryDto.setName(product.getCategory().getName());

        productDto.setCategoryDto(categoryDto);

        return productDto;
    }

}
