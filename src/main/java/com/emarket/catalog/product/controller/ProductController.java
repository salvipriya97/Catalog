package com.emarket.catalog.product.controller;

import com.emarket.catalog.product.model.Product;
import com.emarket.catalog.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

   @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
       return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
   }

   @GetMapping
   @RequestMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
       return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
   }

   @GetMapping
   @RequestMapping("/ids/{ids}")
   public ResponseEntity<List<Product>> getProductsByIds(@PathVariable(value = "ids") List<Long> ids) {
       return new ResponseEntity<>(productService.getProductByIds(ids), HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
       return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
   }

    @PostMapping
    @RequestMapping("/all")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {
        return new ResponseEntity<>(productService.createProducts(products), HttpStatus.OK);
    }

    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity updateProducts(@RequestBody Product product) {
       try {
           productService.getProductById(product.getId());
           return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
       } catch (NoSuchElementException e) {
           return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping
    @RequestMapping("delete/all")
    public void deleteProducts() {
       productService.deleteAllProducts();
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteProductById(@PathVariable(value = "id") Long id) {
       productService.deleteProductById(id);
    }

    @DeleteMapping
    @RequestMapping("/delete/ids/{ids}")
    public void deleteProductsByIds(@PathVariable(value = "ids") List<Long> ids) {
        productService.deleteProductsByIds(ids);
    }


}
