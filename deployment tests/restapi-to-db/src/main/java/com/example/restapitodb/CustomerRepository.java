package com.example.restapitodb;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import com.example.restapitodb.Customer;


public interface CustomerRepository extends JpaRepository <Customer, Integer> {

}