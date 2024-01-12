package com.rediscache.redis.services;

import com.rediscache.redis.domain.Product;
import com.rediscache.redis.exceptions.ProductNotFoundException;
import com.rediscache.redis.repositories.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @CachePut(value = "product", key="#productId")
    public Product updateProduct(Product product, Long productId) {
        Product oldProduct = productRepository.findById(productId)
                .orElseThrow(() ->new ProductNotFoundException("Product with ID "+productId.toString()+" was not found"));
//        Update the attributes
        oldProduct.setProductName(product.getProductName());
        oldProduct.setUom(product.getUom());
        return oldProduct;
    }

    @Override
    @CacheEvict(value = "product", key="#productId")
    public void deleteProduct(Long productId) {
        Product oldProduct = productRepository.findById(productId)
                .orElseThrow(() ->new ProductNotFoundException("Product with ID "+productId.toString()+" was not found"));
        productRepository.delete(oldProduct);
    }

    @Override
    @Cacheable(value = "product", key="#productId")
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->new ProductNotFoundException("Product with ID "+productId.toString()+" was not found"));
        return product;
    }

    @Override
    @Cacheable(value = "product")
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }
}
