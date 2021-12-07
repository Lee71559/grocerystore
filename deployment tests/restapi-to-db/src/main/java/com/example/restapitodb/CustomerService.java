package com.example.restapitodb;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.restapitodb.*;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> listAllCustomer() {

		return customerRepository.findAll();
	}

	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustoemr(Integer id) {
		return customerRepository.findById(id).get();
	}
}