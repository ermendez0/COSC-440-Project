class Room extends Location {
    constructor(name, desc) {
      super();
      this.name = name;
      this.desc = desc;
      this.contents = [];
      this.numberOfItems = 0;
      this.setType("Room");
    }
  
    getContents() {
      return this.contents;
    }
  
    addObject(item) {
      this.contents.push(item);
    }
  
    dropObject(item) {
      const index = this.contents.indexOf(item);
      if (index > -1) {
        this.contents.splice(index, 1);
      }
    }
  
    setContents(contents) {
      this.contents = contents;
    }
  
    getNumberOfItems() {
      this.numberOfItems = this.contents.length;
      return this.numberOfItems;
    }
  
    getName() {
      return this.name;
    }
  
    setName(name) {
      this.name = name;
    }
  
    getDesc() {
      return this.desc;
    }
  
    setDesc(desc) {
      this.desc = desc;
    }
  
    setLocationType() {
      return "Room";
    }
  
    viewRoomContent() {
      console.log("Room Contents");
      console.log();
      if (this.contents.length === 0) {
        console.log("No Item in Room");
      } else {
        for (let i = 0; i < this.contents.length; i++) {
          console.log(i + "  " + this.contents[i]);
        }
      }
      console.log();
    }
  
    toString() {
      return "Room [name=" + this.name + ", desc=" + this.desc + ", contents=" + this.contents + ", numberOfItems=" + this.getNumberOfItems() + "]";
    }
  
    getRoomItem(takeItem) {
      const item = this.contents[takeItem];
      this.dropObject(item);
      return item;
    }
 
    


}
  
  