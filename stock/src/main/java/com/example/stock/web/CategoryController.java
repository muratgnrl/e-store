package com.example.stock.web;

import com.example.stock.api.CategoryDto;
import com.example.stock.api.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResponse> save (@RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.ok(toResponse(service.save(categoryRequest.toDto())));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String id){
        return ResponseEntity.ok(toResponse(service.getCategory(id)));
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> responseList = service.getAllCategory().stream()
                .map(dto -> toResponse(dto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);

    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryRequest categoryRequest, @PathVariable String id){
        return ResponseEntity.ok(toResponse(service.update(categoryRequest.toDto(),id)));
    }
    @DeleteMapping("/{id}")
    public String delete (@PathVariable String id){

        service.delete(id);
        return "Category deleted successfuly";

    }
    public CategoryResponse toResponse(CategoryDto categoryDto) {
        CategoryResponse categoryResponse = new CategoryResponse(categoryDto.getCategoryId(), categoryDto.getName());
        return categoryResponse;
    }
}
