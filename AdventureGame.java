package AdventureText;

import java.util.Scanner;
import java.util.HashMap;


public class AdventureGame {

	private Room rooms[];
	private Items items[];
	private Adventurer adventurer;
	private Wall walls[];
	
	
	//constructors

	public AdventureGame() {
		
	}
	
	//// creating the variables into game
	 
	public void intoGame() {
		rooms = new Room[10];
		items = new Items[10];
		walls = new Wall[4];
		
		for(int i=0; i<4; i++)
			walls[i] = new Wall();
		
	//things/items that will be found in rooms
		
		items[0] = new Items("Drachm", "A small silver coin.");
		items[1] = new Items("Scroll", "An ancient-looking scroll lays on a dusty table.");
		items[2] = new Items("Cerberus Cookies", "Three-headed hound shaped cookies.");
		items[3] = new Items("Minotaur Horn", "A sturdy and sharp horn from a defeated minotaur, could be used as a weapon or crafting material.");
		items[4] = new Items("Divine Relic","A small relic representing one of the legendary beings.");
		items[5] = new Items("Torn Page from a Grimoire","Fragments from a old spell book scattered around the room.");
		items[6] = new Items("Nymph's Tears","A small vial containing tears.");
		items[7] = new Items("Snake Scales","Shedded by Medusa.");
		items[8] = new Items("Nectar of the Gods","A small flask filled with a golden, sweet liquid.");
		items[9] = new Items("Zeus's Lightning Bolt", "The missing thunderbolt, the signature weapon and symbol of power for the Olympian god of thunder; Zeus.");
		
		
		
	// rooms that will be found in the game
		
		rooms[0] = new Room("Oracle's Chamber", "A mysterious room with an ethereal mist hanging in the air. The adventurers journey is guided by the mysterious prophesies that the Oracle holds in store.");
		    rooms[0].addObject(items[1]);
		 
		rooms[1] = new Room("Medusa's Mirror Maze", "A winding labyrinth of mirrors reflecting Medusa's terrifying stare. The adventurer must navigate carefully to avoid catching their own eyes in the deadly reflection. This room contains a pick up items.");
		    rooms[1].addObject(items[0]);
		    rooms[1].addObject(items[7]);
		
		rooms[2] = new Room("Siren's Cove", "A small cove with faint sounds of siren echos of haunting songs.");
		    rooms[2].addObject(items[6]);
		
		rooms[3] = new Room("Athena's Library", "A vast library towering with bookshelves filled with forgotten spells and hidden knowledge.");
		    rooms[3].addObject(items[5]);
		
		rooms[4] = new Room("Cerberus's Chamber", "A dimly lit room where the legendary three-headed guardian, Cerberus, rests in a vigilant slumber. This room contains a pick up item.");
		    rooms[4].addObject(items[2]);
		    rooms[4].addObject(items[9]);
		    
	    rooms[5] = new Room("Ares' War Room", "An expansive room filled weapons lining the walls and trophies displayed as a reminder of defeated foes and past victories.");
	        rooms[5].addObject(items[3]);
	    
	    rooms[6] = new Room("Hera's Grand Hall", "A majestic hall where the queen of the gods holds court.");
	        rooms[6].addObject(items[4]);
	    
	    rooms[7] = new Room("Dionysus' Wine Cellar", "A cellar filled withsbarrels of wine and walls covered by grapefines.");
	        rooms[7].addObject(items[8]);
	        rooms[7].addObject(items[0]);
	    
	    rooms[8] = new Room("Titan's Throne Room", "A grand hall housing the thrones for the powerful titains during the reign.");
	        rooms[8].addObject(items[0]);
	    
	    rooms[9] = new Room("Thunderstorm Observatory", "A room dedicated to the Olympian God, panoramic windows, allowing the view of thunderstroms raging in the sky.");
	
	    
		
	// wall map 
		    
	   walls[0].AddDirection("West", walls[1]);	 
	   walls[0].AddDirection("East", walls[3]);
	   walls[0].AddDirection("North",rooms[0]);
	   
		    
		    
	//room map
	  rooms[0].AddDirection("South", walls[0]);	 
	  rooms[0].AddDirection("North", rooms[1]);
	  
	  
		    
		    
	//starting room for player	    
		 adventurer = new Adventurer(rooms[0],null,0); 
		 
    }
	
	public void startGame() {
		
		intoGame();
		Scanner kBin = new Scanner(System.in);
		String command;
		Location currentLoc ,newLoc= null;
		int takeItem;
		
		boolean b = false;
		 do{	 
		 currentLoc = adventurer.getLocation();
		 showHelpMenu();
		 command = kBin.next();
		 
		 if(command.equalsIgnoreCase("Go")){
		 do {
		 System.out.println("Current Location : "+ currentLoc);
		 System.out.println("Choose direction:");
		 System.out.println("North, South, East, West");
		 String direc = kBin.next();
		 b = checkPathExist(direc,currentLoc);
		 
		 if(b) {
		 newLoc = adventurerNextLocation(direc,currentLoc);
		 adventurer.setLocation((Room) newLoc);
		                }
		 
		 else {
		 System.out.println("There is a Wall");
		 System.out.println("You can't Move to this direction");
		 System.out.println();
		                     }
		                }while(b==false);       
		            }
		 
		 else if(command.equalsIgnoreCase("Look")){
		 if(currentLoc instanceof Room)
		                    ((Room) currentLoc).viewRoomContent();
		 adventurer.viewInventory();
		            }
		 
		 else if(command.equalsIgnoreCase("Take")){
		 if(currentLoc instanceof Room) {
		                ((Room) currentLoc).viewRoomContent();
		 System.out.println("Take the item 0/1/2/3 .. from the room : ");
		 takeItem = Integer.parseInt(kBin.next());
		 Items i = ((Room) currentLoc).getRoomItem(takeItem);
		 adventurer.take(i);
		 adventurer.viewInventory();
		                }
		 
		            }
		 else if(command.equalsIgnoreCase("Drop")){
		 adventurer.viewInventory();
		 System.out.println("Drop the item 0/1/2/3 .. from the Inventory to room : ");
		 takeItem = Integer.parseInt(kBin.next());
		 if(currentLoc instanceof Room) {
		 Items i =adventurer.getInventoryItem(takeItem);
		                    ((Room) currentLoc).addObject(i);
		                    ((Room) currentLoc).viewRoomContent();
		                }
		 
		            }
		 else if(command.equalsIgnoreCase("Use")){
		 adventurer.viewInventory();
		 System.out.println("Use the item 0/1/2/3 .. from the Inventory : ");
		 takeItem = Integer.parseInt(kBin.next());
		 Items i =adventurer.getInventoryItem(takeItem);
		 adventurer.drop(i);
		            }
		 else if(command.equalsIgnoreCase("Exit")){
		 System.exit(0);
		            }
		 else{
		 System.out.println("Invalid command");
		            }
		 
		        }while(true);
		 
		    }
		 public void showHelpMenu() {
		 System.out.println("Choose command: ");
		 System.out.println("Go");
		 System.out.println("Look");
		 System.out.println("Take");
		 System.out.println("Drop");
		 System.out.println("Use");
		 System.out.println("Exit ");
		 System.out.println();
		    }
		 
		 public boolean checkPathExist(String path , Location loc) {
		 
		 HashMap<String ,Location> hm = loc.getRoomDirection();
		 if(hm.containsKey(path)) {
		 if(hm.get(path) instanceof Room)
		 return true;
		        }   
		 return false;
		        }
		 
		 public Location adventurerNextLocation(String path , Location loc) {
		 
		 HashMap<String ,Location> hm = loc.getRoomDirection();
		 if(hm.containsKey(path)) {
		 if(hm.get(path) instanceof Room)
		 return hm.get(path);
		        }
		 return loc;
		

		
	}
	
		
	
		
	}
	
	
	
	

