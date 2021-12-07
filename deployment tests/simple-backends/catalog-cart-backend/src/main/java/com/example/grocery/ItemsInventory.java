package com.example.grocery;

import com.example.grocery.*;

public class ItemsInventory {

	private List<Item> itemsinventory;

	public ItemsInventory(){
		
		itemsinventory = new ArrayList<Item>();
		itemsinventory.append(new Item("Broccoli", 3.50, "Organic Broccoli in green", 10));
		itemsinventory.append(new Item("Bacon", 9.00, "Homemade bacon", 5));
		itemsinventory.append(new Item("Milk", 7.00, "Organic Milk", 12));
		itemsinventory.append(new Item("Eggs", 4.00, "Organic 12 carton", 8));
		itemsinventory.append(new Item("Soda", 2.00, "Homemade Soda", 7));

		itemsinventory.append(new Item("Soap",7.99, "Bar Soap", 20));
		itemsinventory.append(new Item("Shampoo",5.99, "Head & Shoulders", 20));
		itemsinventory.append(new Item("Apple",1.50, "Honeycrisp Apple", 20));
		itemsinventory.append(new Item("Avocado",5.00, "Large Hass Avocado", 20));
		itemsinventory.append(new Item("Blueberries",6.99, "Prepackaged", 20)); 

	}

	public List<Item> getItemsInventory(){ return itemsinventory ; }
}