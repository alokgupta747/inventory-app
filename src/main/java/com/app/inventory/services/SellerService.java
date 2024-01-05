package com.app.inventory.services;

import com.app.inventory.dao.SellerDao;
import com.app.inventory.models.Seller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerDao sellerDao;
    private static final Logger logger = LoggerFactory.getLogger(SellerService.class);

    public ResponseEntity<List<Seller>> getAllSeller(){
        try {
            return new ResponseEntity<>(sellerDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception occurred while getAllSeller", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addSeller(Seller seller) {
        try {
            sellerDao.save(seller);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("Exception occurred while addSeller", e);
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
}
