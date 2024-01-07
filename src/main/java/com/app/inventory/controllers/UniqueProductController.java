package com.app.inventory.controllers;

import com.app.inventory.models.Product;
import com.app.inventory.models.UniqueProduct;
import com.app.inventory.services.ProductService;
import com.app.inventory.services.UniqueProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("uniqueProduct")
public class UniqueProductController {
    @Autowired
    UniqueProductService uniqueProductService;
    private static final Logger logger = LoggerFactory.getLogger(UniqueProductController.class);

    @GetMapping("/")
    public String home(){
        return "Home Product";
    }
    @GetMapping("getUniqueProducts/{prod_id}")
    public ResponseEntity<List<Integer>> getUniqueProduct(@PathVariable("prod_id") Integer productId){
        return uniqueProductService.getUniqueProducts(productId);
    }

//    @PostMapping("addUniqueProduct")
//    public ResponseEntity<String> addUniqueProduct(@RequestBody UniqueProduct uniqueProduct){
//        return uniqueProductService.addUniqueProduct(uniqueProduct);
//    }
}
