package com.rediscache.redis.services;

import com.rediscache.redis.domain.Product;
import com.rediscache.redis.repositories.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Cacheable(value = "product")
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }
}
