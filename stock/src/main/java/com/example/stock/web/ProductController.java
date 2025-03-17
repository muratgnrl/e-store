package com.example.stock.web;

import com.example.stock.api.ProductDto;
import com.example.stock.api.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ProductResponse> save (@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(toResponse(service.save(productRequest.toDto())));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id){
        return ResponseEntity.ok(toResponse(service.getProduct(id)));
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> responseList = service.getAllProducts().stream()
                .map(dto -> toResponse(dto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductResponse> update(@PathVariable String id, @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(toResponse(service.update(productRequest.toDto() , id )));
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable String id){
        service.delete(id);
        return "Product deleted successfuly";
    }


    public ProductResponse toResponse(ProductDto dto) {
        // Manuel olarak ProductResponse nesnesi oluşturuluyor
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(dto.getProductId());
        productResponse.setPrice(dto.getPrice());
        productResponse.setName(dto.getName());
        productResponse.setStock(dto.getStock());
        productResponse.setCategoryDto(dto.getCategoryDto());

        return productResponse;
    }

}
