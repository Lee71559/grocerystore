package com.example.backofficeportal;

import org.springframework.data.repository.CrudRepository;

import com.example.backofficeportal.Order;

public interface OrderRepository extends CrudRepository <Order, Integer> {
	
}