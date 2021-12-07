package com.example.springcustomers;


import lombok.Data;
import lombok.RequiredArgsConstructor;

// @Entity
// @Table(name="Customers")
@Data
@RequiredArgsConstructor
 class Customer {
     
  	 //private @Id @GeneratedValue Long id;
    
    private String name ;
    private String password;
    
    public Customer (String name, String password){
         this.name = name ;
         this.password = password ;
    }
    //private boolean authenticated ;
    // @Column(nullable=false) private String size ;
    //                         private double total ;
    //                         private String status ;

}
