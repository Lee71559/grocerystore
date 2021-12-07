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
@RequiredArgsConstructor
public class Item {

    private String name;
    private double price;
    private String description;
    private int inventory;

    public Item(String name, double price, String description, int inventory){
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventory = inventory;
    }

}

