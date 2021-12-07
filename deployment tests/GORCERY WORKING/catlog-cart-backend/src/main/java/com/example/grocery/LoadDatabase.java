package com.example.grocery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ItemRepository itemRepository, UserRepository userRepository) {

    return args -> {
          /*
            itemRepository.save(new Item("Broccoli", 3.50, "Organic Broccoli in green", 10));
            itemRepository.save(new Item("Bacon", 9.00, "Homemade bacon", 5));
            itemRepository.save(new Item("Milk", 7.00, "Organic Milk", 12));
            itemRepository.save(new Item("Eggs", 4.00, "Organic 12 carton", 8));
            itemRepository.save(new Item("Soda", 2.00, "Homemade Soda", 7));
            itemRepository.save(new Item("Soap",7.99, "Bar Soap", 20));
            itemRepository.save(new Item("Shampoo",5.99, "Head & Shoulders", 20));
            itemRepository.save(new Item("Apple",1.50, "Honeycrisp Apple", 20));
            itemRepository.save(new Item("Avocado",5.00, "Large Hass Avocado", 20));
            itemRepository.save(new Item("Blueberries",6.99, "Prepackaged", 20));

            itemRepository.findAll().forEach(item -> log.info("Preloaded " + item));

            userRepository.save(new User("firstN","lastN", "address", "phone", "email", "password", "creditcard"));

            userRepository.findAll().forEach(user -> log.info("Preloaded " + user));
            */
    };
  }
}