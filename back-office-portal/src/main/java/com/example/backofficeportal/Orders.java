package com.example.backofficeportal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Orders {

	@Id
	@GeneratedValue (strategy=GenerationType.TABLE)
	private Integer id;

	private String items;		// name (opt: item id, description, quantity)

	private String amount ;

	private String paymentStatus ;

	private String paymentMethod ;

	private String deliveryStatus ;

	public Orders (String i, String a, String ps, String pm, String ds){
		items = i;
		amount = a;
		paymentStatus = ps;
		paymentMethod = pm;
		deliveryStatus = ds;
	}

}