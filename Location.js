class Location {
    constructor() {
      this.roomCompass = new Map();
      this.type = "";
    }
  
    getType() {
      return this.type;
    }
  
    setType(type) {
      this.type = type;
    }
  
    AddDirection(direction, location) {
      this.roomCompass.set(direction, location);
    }
  
    getRoomDirection() {
      return this.roomCompass;
    }
  
    setRoomDirection(roomCompass) {
      this.roomCompass = roomCompass;
    }
  
  
    toString() {
      return `Location [type= ${this.type}, roomCompass=${this.roomCompass}]`;
    }
  }
  
  
  