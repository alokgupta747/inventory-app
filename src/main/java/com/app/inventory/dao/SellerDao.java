package com.app.inventory.dao;

import com.app.inventory.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {

}
