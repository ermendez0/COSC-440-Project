package AdventureText;

public class Items {
    
	private String name;
	private String description; 
	
	public Items() {
		
	}
	
	public Items(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	////getters and setters
	
	public String getName() {
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
		
	}
	
	public String getDesciption() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String toString() {
		return "Item = " + name + ", description of item = " + description;
	}
	
}
