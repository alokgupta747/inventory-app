package com.app.inventory.services;

import com.app.inventory.dao.ProductDao;
import com.app.inventory.dao.UserDao;
import com.app.inventory.models.Product;
import com.app.inventory.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

//    public ResponseEntity<List<Product>> getAllProducts(){
//        try {
//            return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
//        } catch (Exception e) {
//            logger.error("Exception occurred while getAllProducts", e);
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//    }

    public ResponseEntity<String> addUser(User user) {
        try {
            userDao.save(user);
            logger.info("User added successfully");
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("Exception occurred while addUser", e);
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
}
