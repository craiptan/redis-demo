package com.rediscache.redis.controllers;

import com.rediscache.redis.domain.Product;
import com.rediscache.redis.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RedisController {
    private final ProductService productService;

    public RedisController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/get_products")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
