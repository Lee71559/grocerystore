package com.example.backofficeportal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backofficeportal.Customers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


public interface CustomersRepository extends JpaRepository <Customers, Integer> {
	Customers findById(Long id);

	@Modifying
	@Query("update Customers c set c.name = ?1, c.password = ?2 where c.id = ?3")
	void updateCustomer( String name, String password, Long id);

	
}