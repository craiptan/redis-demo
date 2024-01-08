package com.rediscache.redis.services;

import com.rediscache.redis.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
}
