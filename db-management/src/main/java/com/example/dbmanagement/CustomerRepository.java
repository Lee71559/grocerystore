package com.example.dbmanagement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.dbmanagement.Customer;


public interface CustomerRepository extends CrudRepository <Customer, Integer> {




	@Query("SELECT id FROM Customer WHERE name=?1 and password=?2")
	public Long loginCheck(String name, String password) ;

	

}