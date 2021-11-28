package com.example.springcustomers;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> { //had to change from Long to Integer for it to work
    Customer findByName(String name) ; 
}
