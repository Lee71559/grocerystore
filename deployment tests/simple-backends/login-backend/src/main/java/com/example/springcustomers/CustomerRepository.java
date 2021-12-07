package com.example.springcustomers;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springcustomers.Customers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


public interface CustomerRepository extends JpaRepository <Customers, Integer> {
    Customers findById(Long id);

    @Modifying
    @Query("update Customers c set c.name = ?1, c.password = ?2 where c.id = ?3")
    void updateCustomer( String name, String password, Long id);

    Customers findByName(String name);
    
}