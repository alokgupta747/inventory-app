package com.app.inventory.controllers;

import com.app.inventory.models.Product;
import com.app.inventory.models.User;
import com.app.inventory.services.ProductService;
import com.app.inventory.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String home(){
        return "Home Product";
    }
//    @GetMapping("getAllProducts")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        return productService.getAllProducts();
//    }

    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
