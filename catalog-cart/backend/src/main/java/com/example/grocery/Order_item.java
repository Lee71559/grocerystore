package com.example.grocery;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "ORDER_ITEM")
public class Order_item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private long orderId;
    private long itemId;
    private String itemName;
    private int quantity;
    private double total;
}

