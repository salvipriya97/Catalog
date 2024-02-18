package com.emarket.catalog.product.repository;

import com.emarket.catalog.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
