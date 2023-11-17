package AdventureText;

import java.util.ArrayList;

public class Adventurer {

	private Room location;
	private Room moveFrom;
	private ArrayList<Thing> inventory;
	private int numofThings;
	
	//constructors
	public Adventurer() {
		location = null;
		moveFrom = null;
		inventory = new ArrayList<Thing>();
		numofThings = 0;
	}
	
	public Adventurer(Room location, Room moveFrom, int numofThings) {
		
		super();
		this.location = location;
		this.moveFrom = moveFrom;
		this.inventory = new ArrayList<Thing>();
		this.numofThings = numofThings;
		
	}
	
	public void take(Thing items) {
		inventory.add(items);
	}
	
	public void drop(Thing items) {
		inventory.remove(items);
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
	
	public ArrayList<Thing>getInventory(){
		return inventory;
	}
	
	public void setInventory(ArrayList<Thing> inventory) {
		this.inventory = inventory;
	}
	
	public int getnumofThings() {
		return numofThings;
	}
	
	public void setnumofThings(int numofThings) {
		this.numofThings = numofThings;
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
	
	public Thing getInventoryItem(int takeItem) {
		Thing thing = inventory.get(takeItem);
		drop(thing);
		return thing;
	}
	
	
	public String toString() {
		 return "Adventurer [location=" + location + ", moveFrom=" + moveFrom + ", inventory=" + inventory
		                + ", numberOfObjects=" + numofThings + "]";
		    }
	
	
	
	
}
