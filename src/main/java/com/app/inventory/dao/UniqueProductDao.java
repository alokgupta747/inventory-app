package com.app.inventory.dao;

import com.app.inventory.models.UniqueProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniqueProductDao extends JpaRepository<UniqueProduct, Integer> {

    @Query("SELECT u.id FROM UniqueProduct u JOIN Purchase p on p.id=u.purchaseId where p.productId=:prodId")
    List<Integer> findByProdId(@Param("prodId") Integer prodId);

}
