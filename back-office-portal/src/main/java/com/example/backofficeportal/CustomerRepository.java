package com.example.backofficeportal;

import org.springframework.data.repository.CrudRepository;

import com.example.backofficeportal.Customer;


public interface CustomerRepository extends CrudRepository <Customer, Integer> {
	
}