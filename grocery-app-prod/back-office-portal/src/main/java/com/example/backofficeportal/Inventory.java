package com.example.backofficeportal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Table;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="INVENTORY")
@NoArgsConstructor
public class Inventory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String itemname ;

	private String description ;

	private Integer storage;		

	private Double unitprice ;

	public Inventory (String itemname, String description, Integer storage, Double unitprice){
		this.itemname = itemname ;
		this.description = description ;
		this.storage = storage ;
		this.unitprice = unitprice ;
	}

}