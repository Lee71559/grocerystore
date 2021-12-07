package com.example.springcustomers;

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

    private int id;
    private String name;
    private double price;
    private String description;
    private int inventory;

    public Item(int id, String name, double price, String description, int inventory){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventory = inventory;
    }

}

