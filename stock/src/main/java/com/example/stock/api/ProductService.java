package com.example.stock.api;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto dto);

    ProductDto getProduct(String id);

    List<ProductDto> getAllProducts();

    ProductDto update(ProductDto dto, String id);

    void delete(String id);
}
