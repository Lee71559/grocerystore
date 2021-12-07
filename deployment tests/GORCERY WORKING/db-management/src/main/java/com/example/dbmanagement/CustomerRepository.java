package com.example.dbmanagement;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import com.example.dbmanagement.Customer;


public interface CustomerRepository extends CrudRepository <Customer, Integer> {

	public Optional <Customer> findById(Long id) ;
	public boolean existsById(Long id);



	@Query("SELECT id FROM Customer WHERE name=?1 and password=?2")
	public Long loginCheck(String name, String password) ;

	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.password = ?1 WHERE c.id = ?2")
	public void updatePassword( String newPassword, Long id);




	// Update Customer Info

	String updateCustomerQuery = "UPDATE Customer c SET" + 
								 " c.name = ?1, c.password = ?2," + 
								 " c.address = ?3, c.city = ?4," + 
								 " c.state = ?5, c.zip = ?6," + 
								 " c.phone = ?7, c.cardNumber = ?8," + 
								 " c.expMonth = ?9, c.expYear = ?10," + 
								 " c.cvv = ?11, c.email = ?12," + 
								 " c.notes = ?13 WHERE c.id = ?14" ;




	@Transactional
	@Modifying
	@Query(updateCustomerQuery)
	public void updateCustomer( String name, String password,
							   String address, String city,
							   String state, String zip,
							   String phone, String cardNumber,
							   String expMonth, String expYear,
							   String cvv, String email, 
							   String notes, Long id);

	

}