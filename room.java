import java.util.ArrayList;

public class Room extends Location {
 
 private String name;
 private String desc;
 private ArrayList<Item> contents;
 private int numberOfItems;
 public Room() {
 contents = new ArrayList<>();
 setType("Room");
    }
 
 public Room(String name, String desc) {
 this.name = name;
 this.desc = desc;
 contents = new ArrayList<>();
 setType("Room");
    }

 public ArrayList<Items>  getContents() {
 return contents;
    }
 
 public void addObject(Item item){
 contents.add(item);
    }
 public void dropObject(Item item){
 contents.remove(item);
    }
 

 public void setContents(ArrayList<Item> contents) {
 this.contents = contents;
    }

 public int getNumberOfItems() {
 numberOfItems = contents.size();
 return numberOfItems;
    }

 public String getName() {
 return name;
    }
 public void setName(String name) {
 this.name = name;
    }
 public String getDesc() {
 return desc;
    }
 public void setDesc(String desc) {
 this.desc = desc;
    }
 public String setLocationType() {
 return "Room";
 
    }
 
 public void viewRoomContent() {
 System.out.println("Room Contents");
 System.out.println();
 if(contents.size()==0)
 System.out.println("No Item in Room");
 else {
 for(int i = 0 ; i < contents.size(); i++)
 System.out.println(i + "  " + contents.get(i));
        }
 System.out.println();
    }

    @Override
 public String toString() {
 return "Room [name=" + name + ", desc=" + desc + ", contents=" + contents
                + ", numberOfItemss=" + getNumberOfItemss() + "]";
    }

 public Item getRoomItem(int takeItem) {
 Item t = contents.get(takeItem);
 dropObject(t);
 return t;
 
    }
}
