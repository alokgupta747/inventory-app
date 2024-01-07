package com.app.inventory.dao;

import com.app.inventory.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

}
