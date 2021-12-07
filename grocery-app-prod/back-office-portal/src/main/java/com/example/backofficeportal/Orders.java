package com.example.backofficeportal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.TableGenerator;

@Data
@Entity
@Table(name="ORDERS")
@NoArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long customerid ;

	private String details ;

	private Double amount ;

	private String status;		

	
	public Orders (Long customerid, String details, Double amount, String status){
		
		this.customerid = customerid;
		this.details = details ;
		this.amount = amount ;
		this.status = status ;		
	}

}