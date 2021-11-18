package com.example.dbmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import com.example.dbmanagement.* ;

@Slf4j
//@Controller
public class DBController {


	@Autowired
	private CustomerRepository customerRepository ;

	// @Autowired
	// private OrderRepository orderRepository ;

	// @Autowired
	// private InventoryRepository inventoryRepository ;


	public DBController(){
		preloadData();
	}


	private void preloadData() {

		Customer customer1 = new Customer("Jason Kidd", "123534");
		Customer customer2 = new Customer("Tim Ducan", "66666");
		Customer customer3 = new Customer("Larry Bird", "431123");

		customerRepository.save(customer1) ;
		customerRepository.save(customer2) ;
		customerRepository.save(customer3) ;

/*
		Order order1 = new Order("Broccoli * 1; Apple * 2", "50.00", "PENDING");
		Order order2 = new Order("Milk * 1; Soda * 2", "60.00", "PENDING");
		Order order3 = new Order("Soap * 1; Bacon * 2", "90.00", "PENDING");

		orderRepository.save(order1) ;
		orderRepository.save(order2) ;
		orderRepository.save(order3) ;


		Inventory item1 = new Inventory ("Broccoli", "Organic", "5", "1.00") ;
		Inventory item2 = new Inventory ("Bacon", "Organic","5", "3.99") ;
		Inventory item3 = new Inventory ("Milk", "Organic", "5", "4.99") ;
		Inventory item4 = new Inventory ("Soda", "Diet, 12 Cans", "5", "6.99") ;
		Inventory item5 = new Inventory ("Soap", "Mint", "5", "1.99") ;


		inventoryRepository.save(item1) ;
		inventoryRepository.save(item2) ;
		inventoryRepository.save(item3) ;
		inventoryRepository.save(item4) ;
		inventoryRepository.save(item5) ;
		*/

	}


}






























