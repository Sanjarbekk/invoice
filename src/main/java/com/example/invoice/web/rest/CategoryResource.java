package com.example.invoice.web.rest;

import com.example.invoice.service.CategoryService;
import com.example.invoice.service.dto.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryResource {

    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        log.debug("Create New Category : {}", categoryDTO);
        CategoryDTO result = categoryService.save(categoryDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/categories")
    ResponseEntity<List<CategoryDTO>> getAllCategories() {
        log.debug("Get All Categories");
        List<CategoryDTO> result = categoryService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/categories/{productId}")
    ResponseEntity<CategoryDTO> getCategoryByProductId(@PathVariable Long productId) {
        log.debug("Get Category by productId : {}", productId);
        CategoryDTO result = categoryService.getCategoryByProductId(productId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        log.debug("REST request to delete Category : {}", id);
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        log.debug("REST request to get Category : {}", id);
        CategoryDTO result = categoryService.findOneDto(id);
        return ResponseEntity.ok(result);
    }
}