package com.example.backofficeportal;

import org.springframework.data.repository.CrudRepository;

import com.example.backofficeportal.Orders;

import java.util.*;


public interface OrdersRepository extends CrudRepository <Orders, Integer> {
	
}