package com.example.dbmanagement;


import java.util.List;


import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.http.ResponseEntity;

import com.example.dbmanagement.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping()
class DBController {

	@Autowired
	private CustomerRepository customerRepository ;

	@Autowired
	private OrdersRepository ordersRepository ;

	@Autowired 
	private InventoryRepository inventoryRepository ;

	@GetMapping("/ping")
	public ResponseEntity<String> ping(){
		
		return ResponseEntity.ok("DB management is alive !");
	}



	/*Task 1 Login-service Requests */

	@GetMapping("/customer")
	public ResponseEntity<String> CheckCustomerById(@RequestParam String id) {

		Customer target = findCustomerById(Long.parseLong(id));
		if (target != null) return ResponseEntity.ok(target.getName());
		return ResponseEntity.ok("Customer Not Found");

	}

	@GetMapping(path = "/customer/{name}/{password}")
	public ResponseEntity<String> LoginCheck(@PathVariable String name, 
													  @PathVariable String password) {

		return ResponseEntity.ok(loginCheck(name, password)+"");

	}


	@GetMapping(path = "/newcustomer/{name}/{password}")
	public ResponseEntity<String> NewCustomer(@PathVariable String name, 
													  @PathVariable String password) {

		return ResponseEntity.ok(newCustomer(name, password)+"");

	}



	/* Task 2 Catlog-Cart-service Requests */

	@GetMapping(path = "/neworder/{customerid}/{details}")
	public ResponseEntity<String> newOrder(@PathVariable String customerid, @PathVariable String details) {

		return ResponseEntity.ok( createNewOrder(customerid, details) +"");
	}

	// @GetMapping(path = "/findorder/{customerid}")
	// public ResponseEntity<String> findOrderByCustomerId(@PathVariable String customerid) {
	// 	return null;
	// }


	/* Task 3 payment-process requests */

	@GetMapping(path = "/orderstopay/{id}")
	public ResponseEntity<String> FindOrder(@PathVariable String id) {

		log.info("/orderstopay/"+id);

		Orders o = findOrderById(Long.parseLong(id));

		if (o == null) return ResponseEntity.ok( "No Such Order " + id );

		return ResponseEntity.ok( o.getId() + " " + o.getDetails() + " " + o.getAmount() + " " + o.getStatus());
	}








	/* Functional Methods*/

	

	/* Query Methods */ 

	/* Task 1:*/
	private Customer findCustomerById(Long id) {

		if (customerRepository.existsById(id)) {
			Optional<Customer> customerResponse = customerRepository.findById(id);
			Customer costomer = customerResponse.get();

			return costomer;
		} 

		return null;
	
	}

	private Long loginCheck(String name, String password) {
		
		return customerRepository.loginCheck(name,password);
	
	}

	private Long newCustomer(String name, String password) {
		Customer newcustomer = new Customer(name, password);
		customerRepository.save(newcustomer);

		return customerRepository.count();
	}


	// Task 2:

	// primary request
	private long createNewOrder(String customerid, String details) {

		// details should be in form of "itemname quantity, itemname quantity, ..."

		// boolean available = true;

		// check quantity
			// for item: details 
				//available = checkOrderWithInventory(itemname, quantity)

			// if available = yes: 
				//calculate amount, 
				//create order(details, amount, status)
				// update inventory, 
		Orders newOrder = new Orders(customerid ,details, 35.50, "Order Created");
		
		ordersRepository.save(newOrder);

		return ordersRepository.count();


			// no: return null
		
	}

	//secondary requests:
	// return orders by customerid



	// Task 3:
	private Orders findOrderById(Long id) {

		if (ordersRepository.existsById(id)){
			Optional<Orders> orderResponse = ordersRepository.findById(id);
			Orders order = orderResponse.get() ;

			return order;
		
		} else {
		
			return null;
		
		}	

	}


}