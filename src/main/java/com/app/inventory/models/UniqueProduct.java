package com.app.inventory.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UniqueProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String colour;
    private String shop;
    @Column(name = "purchase_id")
    private Integer purchaseId;
}
