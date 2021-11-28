package com.example.springcustomers;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Customers")
@Data
@RequiredArgsConstructor
 class Customer {
     
  	private @Id @GeneratedValue Long id;
    @Column(unique=true, nullable=false) private String name ;
    @Column(nullable=false) private String password;
    @Column(nullable=false) private boolean authenticated ;
    // @Column(nullable=false) private String size ;
    //                         private double total ;
    //                         private String status ;

}
