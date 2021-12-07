package com.example.springcustomers;

import com.example.springcustomers.*;

import java.util.List; // import just the List interface
import java.util.ArrayList;

public class ItemsInventory {

	private List<Item> itemsinventory;

	public ItemsInventory(){
		
		itemsinventory = new ArrayList<Item>();
		itemsinventory.add(new Item( 0, "Broccoli", 3.50, "Organic Broccoli in green", 10));
		itemsinventory.add(new Item( 1, "Bacon", 9.00, "Homemade bacon", 5));
		itemsinventory.add(new Item( 2, "Milk", 7.00, "Organic Milk", 12));
		itemsinventory.add(new Item( 3, "Eggs", 4.00, "Organic 12 carton", 8));
		itemsinventory.add(new Item( 4, "Soda", 2.00, "Homemade Soda", 7));

		itemsinventory.add(new Item( 5, "Soap",7.99, "Bar Soap", 20));
		itemsinventory.add(new Item( 6, "Shampoo",5.99, "Head & Shoulders", 20));
		itemsinventory.add(new Item( 7, "Apple",1.50, "Honeycrisp Apple", 20));
		itemsinventory.add(new Item( 8, "Avocado",5.00, "Large Hass Avocado", 20));
		itemsinventory.add(new Item( 9, "Blueberries",6.99, "Prepackaged", 20)); 

	}

	public List<Item> getItemsInventory(){ return itemsinventory ; }
}