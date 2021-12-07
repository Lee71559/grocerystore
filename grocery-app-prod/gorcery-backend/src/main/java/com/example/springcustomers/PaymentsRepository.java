package com.example.springcustomers;
 
 import org.springframework.data.jpa.repository.JpaRepository;

 interface PaymentsRepository extends JpaRepository<PaymentsCommand, Long>{

 }