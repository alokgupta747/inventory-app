package com.app.inventory.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "seller_id")
    private Integer sellerId;
    @Column(name = "cost_price")
    private BigDecimal costPrice;
}
