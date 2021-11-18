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
public class Inventory {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "inventory_generator")
    @TableGenerator(name="inventory_generator", table="id_generator", schema="Inventory")
    private Long id;

	private String itemname ;

	private String description ;

	private String storage;		

	private String unitprice ;

	public Inventory (String itemname, String description, String storage, String unitprice){
		this.itemname = itemname ;
		this.description = description ;
		this.storage = storage ;
		this.unitprice = unitprice ;
	}

}