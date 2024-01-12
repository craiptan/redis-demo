package com.rediscache.redis.controllers;

import com.rediscache.redis.domain.Product;
import com.rediscache.redis.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RedisController {
    private final ProductService productService;

    public RedisController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Long id){
        return ResponseEntity.ok(productService.updateProduct(product,id));
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product with id: "+id+ " Deleted Successfully !";
    }

}
