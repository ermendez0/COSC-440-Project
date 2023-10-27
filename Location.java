package AdventureText;

import java.util.HashMap;

public class Location {

	private HashMap<String, Location> roomCompass;
	private String type;
	
	
	public Location() {
		roomCompass = new HashMap<String, Location>();
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void AddDirection(String direction, Location location) {
		roomCompass.put(direction, location);
	}
	
	public HashMap<String, Location> getRoomDirection(){
		return roomCompass;
	}
	
	public void setRoomDirection(HashMap<String, Location> roomCompass) {
		this.roomCompass = roomCompass;
	}
	
	///CHANGE OUTPUT OF THIS STRING LATER
	
	public String toString() {
		return "Location [type= " + type + ", roomCompass=" + roomCompass + "]";
	}
	
}
