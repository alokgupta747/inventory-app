package com.app.inventory.controllers;

import com.app.inventory.models.Purchase;
import com.app.inventory.services.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    @GetMapping("/")
    public String home(){
        return "Home Purchase";
    }
    @GetMapping("getAllPurchases")
    public ResponseEntity<List<Purchase>> getAllPurchase(){
        return purchaseService.getAllPurchase();
    }

    @PostMapping("addPurchase")
    public ResponseEntity<String> addProduct(@RequestBody Purchase purchase){
        return purchaseService.addPurchase(purchase);
    }
}
