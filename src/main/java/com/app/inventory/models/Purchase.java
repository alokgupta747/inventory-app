package com.app.inventory.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @Column(name = "seller_id")
    private Integer sellerId;
    @Column(name = "cost_price")
    private BigDecimal costPrice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "product_id")
    private Integer productId;
}
