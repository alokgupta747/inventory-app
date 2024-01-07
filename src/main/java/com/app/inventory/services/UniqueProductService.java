package com.app.inventory.services;

import com.app.inventory.dao.UniqueProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniqueProductService {
    @Autowired
    UniqueProductDao uniqueProductDao;
    private static final Logger logger = LoggerFactory.getLogger(UniqueProductService.class);

    public ResponseEntity<List<Integer>> getUniqueProducts(Integer productId){
        try {
            List<Integer> listOfUniqueProdIDs = uniqueProductDao.findByProdId(productId);
//            return productOptional.map(uniqueProduct -> new ResponseEntity<>(uniqueProduct, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            return new ResponseEntity<>(listOfUniqueProdIDs, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception occurred while getAllProducts", e);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    public ResponseEntity<String> addUniqueProduct(UniqueProduct uniqueProduct) {
//        try {
//            uniqueProductDao.save(uniqueProduct);
//            return new ResponseEntity<>("Success", HttpStatus.CREATED);
//        } catch (Exception e){
//            logger.error("Exception occurred while addProduct", e);
//        }
//        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
//    }
}
