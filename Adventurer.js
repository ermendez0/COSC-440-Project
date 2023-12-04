class Adventurer {
    constructor(location, moveFrom, numofItems) {
        this.location = location;
        this.moveFrom = moveFrom;
        this.inventory = [];
        this.numofItems = numofItems;
    }

    take(item) {
        this.inventory.push(item);
    }

    drop(item) {
        const index = this.inventory.indexOf(item);
        if (index > -1) {
            this.inventory.splice(index, 1);
        }
    }

    getLocation() {
        return this.location;
    }

    setLocation(location) {
        this.location = location;
    }

    getMoveFrom() {
        return this.moveFrom;
    }

    setMoveFrom(moveFrom) {
        this.moveFrom = moveFrom;
    }

    getInventory() {
        return this.inventory;
    }

    setInventory(inventory) {
        this.inventory = inventory;
    }

    getNumOfItems() {
        return this.numofItems;
    }

    setNumOfItems(numofItems) {
        this.numofItems = numofItems;
    }

    viewInventory() {
        console.log("Adventurer's Inventory: ");
        console.log();

        if (this.inventory.length === 0) {
            console.log("No items in Inventory.");
        } else {
            for (let i = 0; i < this.inventory.length; i++) {
                console.log(i + ". " + this.inventory[i]);
            }
        }
        console.log();
    }

    getInventoryItem(takeItem) {
        const item = this.inventory[takeItem];
        this.drop(item);
        return item;
    }

    toString() {
        return "Adventurer [location=" + this.location + ", moveFrom=" + this.moveFrom + ", inventory=" + this.inventory
            + ", numberOfObjects=" + this.numofItems + "]";
    }
}

