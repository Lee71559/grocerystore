package com.example.dbmanagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Orders extends Payload {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "order_generator")
	@TableGenerator(name="order_generator", table="id_generator", schema="Orders")
	private Long id;

	private String customerid ;

	private String details ;

	private Double amount ;

	private String status;		

	
	public Orders (String customerid, String details, Double amount, String status){
		this.details = details ;
		this.amount = amount ;
		this.status = status ;		
	}

}