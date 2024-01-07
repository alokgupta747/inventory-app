package com.app.inventory.controllers;

import com.app.inventory.models.Product;
import com.app.inventory.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
    public String home(){
        return "Home Product";
    }
    @GetMapping("getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
