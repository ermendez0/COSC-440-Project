package AdventureText;

public class Thing {
 
	private String name;
	private String description;
	
	//constructor
	
	public Thing() {
		
	}
	
	public Thing(String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
	//setters and getters
	
	public String getName() {
		return name;
		
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String look() {
		return getDescription();
		
	}
	
	
	public String toString() {
		 return "Thing name=" + name + ", description=" + description ;
		    }
}
