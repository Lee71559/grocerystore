package com.example.dbmanagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_generator")
    @TableGenerator(name="customer_generator", table="id_generator", schema="Customer")
    private Long id;

	private String name; 

	private String password;
    
    private String address;

    private String city;

    private String state;

    private String zip;

    private String phone;

    private String cardNumber;

    private String expMonth;

    private String expYear;

    private String cvv;

    private String email;

    private String notes;

    public Customer (String name, String password){
    	this.name = name ;
    	this.password = password ;
    }


}