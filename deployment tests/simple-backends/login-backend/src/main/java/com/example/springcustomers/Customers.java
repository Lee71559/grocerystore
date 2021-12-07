package com.example.springcustomers;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.TableGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name="CUSTOMERS")
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public Customers (String name, String password){
      this.name = name ;
      this.password = password ;
    }


}