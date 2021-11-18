package com.example.dbmanagement;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.dbmanagement.Orders;



public interface OrdersRepository extends CrudRepository <Orders, Integer> {

	public Optional<Orders> findById(Long id);
	public boolean existsById(Long id);
}