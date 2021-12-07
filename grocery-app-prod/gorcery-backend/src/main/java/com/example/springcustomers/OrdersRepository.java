package com.example.springcustomers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springcustomers.Orders;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


public interface OrdersRepository extends JpaRepository <Orders, Integer> {

	Orders findById(Long id);

	
	@Modifying
	@Query("update Orders o set o.details = ?1, o.amount = ?2, o.status = ?3 where o.id = ?4")
	void updateOrder( String details, Double amount, String status, Long id);

	@Modifying
	@Query("update Orders o set o.status = ?1 where o.id = ?2")
	void updateOrderStatus( String status, Long id);
	
}