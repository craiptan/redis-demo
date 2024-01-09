package com.rediscache.redis.services;

import com.rediscache.redis.domain.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public Product updateProduct(Product product, Integer productId);
    public void deleteProduct(Integer productId);
    public Product getProductById(Integer productId);
    public List<Product> getAllProducts();
}
