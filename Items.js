class Items {
    constructor(name, description) {
      this.name = name;
      this.description = description;
    }
    
    getName() {
      return this.name;
    }
    
    setName(name) {
      this.name = name;
    }
    
    getDescription() {
      return this.description;
    }
    
    setDescription(description) {
      this.description = description;
    }
    
    toString() {
      return "Item = " + this.name + ", description of item = " + this.description;
    }
  }
  
  