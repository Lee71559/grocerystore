package com.example.backofficeportal;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.backofficeportal.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomersRepository customerRepository;

	public List<Customers> listAllCustomers() {

		return customerRepository.findAll();
	}

	public void save(Customers customer) {
		customerRepository.save(customer);
	}

	public Customers findCustomerById(Long id) {
		return customerRepository.findById(id);
	}

	public Long count(){
		return customerRepository.count();
	}

	public void updateCustomer( String name, String password, Long id){
		customerRepository.updateCustomer( name, password, id);
	}
}