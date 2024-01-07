package com.app.inventory.services;

import com.app.inventory.dao.ProductDao;
import com.app.inventory.dao.PurchaseDao;
import com.app.inventory.dao.UniqueProductDao;
import com.app.inventory.models.Product;
import com.app.inventory.models.Purchase;
import com.app.inventory.models.UniqueProduct;
import com.app.inventory.utility.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    PurchaseDao purchaseDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    UniqueProductDao uniqueProductDao;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    public ResponseEntity<List<Purchase>> getAllPurchase(){
        try {
            return new ResponseEntity<>(purchaseDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception occurred while getAllPurchase", e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> addPurchase(Purchase purchase) {
        try {
            if (!productDao.existsById(purchase.getProductId()))
                throw new CustomException("ProductId doesn't exists. Please create Product before creating purchase");
            Purchase purchaseSaved = purchaseDao.save(purchase);
            logger.info("Added Purchase entry");
            Product productToUpdate = productDao.findById(purchase.getProductId()).orElseThrow(() -> new CustomException("Product Id not found"));
            productToUpdate.setCount(productToUpdate.getCount() + purchase.getQuantity());
            productDao.save(productToUpdate);
            logger.info("Updated count of " + productToUpdate.getName());
            insertUniqueProductRecords(purchase.getQuantity(), purchaseSaved.getId());

            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("Exception occurred while addPurchase", e);
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    private void insertUniqueProductRecords(Integer quantity, Integer purchaseId) {
        for (int i = 0; i < quantity; i++) {
            UniqueProduct uniqueProduct = new UniqueProduct();
            uniqueProduct.setPurchaseId(purchaseId);
            uniqueProductDao.save(uniqueProduct);
        }
        logger.info("Added Unique Products for " + quantity + " items");
    }
}
