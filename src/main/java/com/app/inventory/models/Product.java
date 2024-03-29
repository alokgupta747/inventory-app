package com.app.inventory.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private Integer count;
}
