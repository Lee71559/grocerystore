package com.example.restapitodb;


import com.example.restapitodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;



@RestController
@RequestMapping
public class customerController {

	@Autowired 
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> list() {


		// Iterator<Customer> res = customerService.listAllCustomer();
		// List<Customer> customers = new ArrayList<>();
		// res.forEachRemaining(customers::add);

		return customerService.listAllCustomer();
	}
}