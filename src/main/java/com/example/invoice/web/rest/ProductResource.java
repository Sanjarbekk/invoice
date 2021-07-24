package com.example.invoice.web.rest;

import com.example.invoice.service.ProductService;
import com.example.invoice.service.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        log.debug("Create New Product : {}", productDTO);
        ProductDTO result = productService.save(productDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/products")
    ResponseEntity<List<ProductDTO>> getAllProducts() {
        log.debug("Get All Products");
        List<ProductDTO> result = productService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.debug("REST request to delete Product : {}", id);
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        log.debug("REST request to get Product : {}", id);
        ProductDTO result = productService.findOneDto(id);
        return ResponseEntity.ok(result);
    }
}