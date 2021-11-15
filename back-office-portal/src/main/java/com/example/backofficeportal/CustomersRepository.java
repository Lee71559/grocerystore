package com.example.backofficeportal;

import org.springframework.data.repository.CrudRepository;

import com.example.backofficeportal.Customers;

import java.util.*;


public interface CustomersRepository extends CrudRepository <Customers, Integer> {
	
}