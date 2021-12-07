package com.example.backofficeportal;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.example.backofficeportal.Inventory;


public interface InventoryRepository extends JpaRepository <Inventory, Integer> {

	public Optional <Inventory> findById(Long id) ;
	public boolean existsById (Long id) ; 

	@Transactional
	@Modifying
	@Query("UPDATE Inventory inv SET inv.itemname = ?1, inv.description = ?2, inv.storage = ?3, inv.unitprice = ?4   WHERE inv.id = ?5")
	public int updateInventory( String itemname, String description, Integer storage, Double unitprice, Long id);

}