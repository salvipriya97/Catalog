package com.emarket.catalog.product.service;

import com.emarket.catalog.product.model.Product;
import com.emarket.catalog.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product getProductById(Long id) {
      return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getProductByIds(List<Long> ids) {
        return productRepository.findAllById(ids);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> createProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public void deleteProductsByIds(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }


}
