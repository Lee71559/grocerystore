package com.example.dbmanagement;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import com.example.dbmanagement.Orders;



public interface OrdersRepository extends CrudRepository <Orders, Integer> {

	public Optional<Orders> findById(Long id);
	public boolean existsById(Long id);


	@Transactional
	@Modifying
	@Query("UPDATE Orders o SET o.status = ?1 WHERE o.id = ?2")
	public int updateStatus( String status, Long id);

	// @Transactional
	// @Modifying
	// @Query("SELECT id FROM ORDERS WHERE CUSTOMERID = ?1")
	// public Long findByCustomerId( String customerid);

}