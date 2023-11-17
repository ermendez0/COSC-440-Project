package AdventureText;

import java.util.ArrayList;

public class Adventurer {

	private Room location;
	private Room moveFrom;
	private ArrayList<Items> inventory;
	private int numofItems;
	
	//constructors
	public Adventurer() {
		location = null;
		moveFrom = null;
		inventory= new ArrayList<Items>();
		numofItems = 0;
	
	}
	public Adventurer(Room location, Room moveFrom, int numofItems) {
		
		super();
		this.location = location;
		this.moveFrom = moveFrom;
		this.inventory = new ArrayList<Items>();
		this.numofItems = numofItems;
		
	}
	
	public void take(Items item) {
		inventory.add(item);
	}
	
	public void drop(Items item) {
		inventory.remove(item);
	}
	
	//setters and getters
	
	public Room getLocation() {
		return location;
		
	}
	
	public void setLocation(Room location) {
		this.location = location;
	}
	
	public Room getmoveFrom() {
		return moveFrom;
	}
	
	public void setmoveFrom(Room moveFrom) {
		this.moveFrom = moveFrom;
	}
	
	public ArrayList<Items>getInventory(){
		return inventory;
	}
	
	public void setInventory(ArrayList<Items> inventory) {
		this.inventory = inventory;
	}
	
	public int getnumofItems() {
		return numofItems;
	}
	
	public void setnumofThings(int numofItems) {
		this.numofItems = numofItems;
	}
	
	
	
	public void viewInventory() {
		System.out.println("Adventurers Inventory: ");
		System.out.println();
		
		//checking to see if inventory is empty
		if(inventory.size()==0)
			System.out.println("No items in Inventory.");
		
		else //printing out current inventory
		{
			for(int i=0; i<inventory.size(); i++)
				System.out.println(i + ". " + inventory.get(i));
		}
		        System.out.println();
		   	
	}
	
	public Items getInventoryItem(int takeItem) {
		Items item = inventory.get(takeItem);
		drop(item);
		return item;
	}
	
	
	public String toString() {
		 return "Adventurer [location=" + location + ", moveFrom=" + moveFrom + ", inventory=" + inventory
		                + ", numberOfObjects=" + numofItems + "]";
		    }
	
	

	
}
