package com.app.inventory.controllers;

import com.app.inventory.models.Seller;
import com.app.inventory.services.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

    @GetMapping("/")
    public String home(){
        return "Home Seller";
    }
    @GetMapping("getSeller")
    public ResponseEntity<List<Seller>> getAllSeller(){
        return sellerService.getAllSeller();
    }

    @PostMapping("addSeller")
    public ResponseEntity<String> addSeller(@RequestBody Seller seller){
        return sellerService.addSeller(seller);
    }
}
