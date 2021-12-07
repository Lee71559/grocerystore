
package com.example.springcustomers;

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
@Table(name="PROCESS")
@NoArgsConstructor
public class Process {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long customerid ;

	private Long orderid ;

	public Process (Long customerid){

		this.customerid = customerid ;

	}

}