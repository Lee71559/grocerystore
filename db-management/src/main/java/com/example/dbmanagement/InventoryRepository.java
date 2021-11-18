package com.example.dbmanagement;

import org.springframework.data.repository.CrudRepository;

import com.example.dbmanagement.Inventory;


public interface InventoryRepository extends CrudRepository <Inventory, Integer> {

}