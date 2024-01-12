package com.rediscache.redis.services;

import com.rediscache.redis.domain.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public Product updateProduct(Product product, Long productId);
    public void deleteProduct(Long productId);
    public Product getProductById(Long productId);
    public List<Product> getAllProducts();
}
