package com.example.dbmanagement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Autowired;



@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


	@Bean 
	CommandLineRunner initDatabase(CustomerRepository customerRepository,
								   OrdersRepository ordersRepository, 
								   InventoryRepository inventoryRepository) {

		return args -> {
			
			preloadData(customerRepository, ordersRepository,inventoryRepository);
			customerRepository.findAll().forEach(customer -> log.info("Preloaded" + customer));
			ordersRepository.findAll().forEach(orders -> log.info("Preloaded" + orders));
			inventoryRepository.findAll().forEach(inventory -> log.info("Preloaded" + inventory));

		};

	}

	private void preloadData(CustomerRepository customerRepository,
								   OrdersRepository ordersRepository, 
								   InventoryRepository inventoryRepository) {

		Customer customer1 = new Customer("a", "111");
		Customer customer2 = new Customer("Tim Ducan", "66666");
		Customer customer3 = new Customer("Larry Bird", "431123");
		Customer customer4 = new Customer("Jason Kidd", "123534");

		customerRepository.save(customer1) ;
		customerRepository.save(customer2) ;
		customerRepository.save(customer3) ;
		customerRepository.save(customer4) ;

		
		Orders order1 = new Orders("1", "Broccoli * 1; Apple * 2", 50.00, "ORDER CREATED");
		Orders order2 = new Orders("2", "Milk * 1; Soda * 2", 60.00, "PENDING");
		Orders order3 = new Orders("3", "Soap * 1; Bacon * 2", 90.00, "PENDING");
		Orders order4 = new Orders("4", "Milk * 1; Bacon * 2", 40.00, "PENDING");

		ordersRepository.save(order1) ;
		ordersRepository.save(order2) ;
		ordersRepository.save(order3) ;


		Inventory item1 = new Inventory ("Broccoli", "Organic", 5, 1.00) ;
		Inventory item2 = new Inventory ("Bacon", "Organic",5, 3.99) ;
		Inventory item3 = new Inventory ("Milk", "Organic", 5, 4.99) ;
		Inventory item4 = new Inventory ("Soda", "Diet, 12 Cans", 5, 6.99) ;
		Inventory item5 = new Inventory ("Soap", "Mint", 5, 1.99) ;


		inventoryRepository.save(item1) ;
		inventoryRepository.save(item2) ;
		inventoryRepository.save(item3) ;
		inventoryRepository.save(item4) ;
		inventoryRepository.save(item5) ;
		

	}


}