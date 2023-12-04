
 class AdventureGame {
    constructor() {
        this.rooms = [];
        this.items = [];
        this.adventurer = null;
        this.walls = [];
    }

    intoGame() {
        this.rooms = new Array(10);
        this.items = new Array(10);
        this.walls = new Array(4);
        for (let i = 0; i < 4; i++) {
            this.walls[i] = new Wall();
        }

        this.items[0] = new Items("Drachm", "A small silver coin.");
        this.items[1] = new Items("Scroll", "An ancient-looking scroll lays on a dusty table.");
        this.items[2] = new Items("Cerberus Cookies", "Three-headed hound shaped cookies.");
        this.items[3] = new Items("Minotaur Horn", "A sturdy and sharp horn from a defeated minotaur, could be used as a weapon or crafting material.");
        this.items[4] = new Items("Divine Relic", "A small relic representing one of the legendary beings.");
        this.items[5] = new Items("Torn Page from a Grimoire", "Fragments from a old spell book scattered around the room.");
        this.items[6] = new Items("Nymph's Tears", "A small vial containing tears.");
        this.items[7] = new Items("Snake Scales", "Shedded by Medusa.");
        this.items[8] = new Items("Nectar of the Gods", "A small flask filled with a golden, sweet liquid.");
        this.items[9] = new Items("Zeus's Lightning Bolt", "The missing thunderbolt, the signature weapon and symbol of power for the Olympian god of thunder; Zeus.");

        this.rooms[0] = new Room("Oracle's Chamber", "A mysterious room with an ethereal mist hanging in the air. The adventurers journey is guided by the mysterious prophesies that the Oracle holds in store.");
        this.rooms[0].addObject(this.items[1]);
        this.rooms[1] = new Room("Medusa's Mirror Maze", "A winding labyrinth of mirrors reflecting Medusa's terrifying stare. The adventurer must navigate carefully to avoid catching their own eyes in the deadly reflection. This room contains a pick up items.");
        this.rooms[1].addObject(this.items[0]);
        this.rooms[1].addObject(this.items[7]);
        this.rooms[2] = new Room("Siren's Cove", "A small cove with faint sounds of siren echos of haunting songs.");
        this.rooms[2].addObject(this.items[6]);
        this.rooms[3] = new Room("Athena's Library", "A vast library towering with bookshelves filled with forgotten spells and hidden knowledge.");
        this.rooms[3].addObject(this.items[5]);
        this.rooms[4] = new Room("Cerberus's Chamber", "A dimly lit room where the legendary three-headed guardian, Cerberus, rests in a vigilant slumber. This room contains a pick up item.");
        this.rooms[4].addObject(this.items[2]);
        this.rooms[4].addObject(this.items[9]);
        this.rooms[5] = new Room("Ares' War Room", "An expansive room filled weapons lining the walls and trophies displayed as a reminder of defeated foes and past victories.");
        this.rooms[5].addObject(this.items[3]);
        this.rooms[6] = new Room("Hera's Grand Hall", "A majestic hall where the queen of the gods holds court.");
        this.rooms[6].addObject(this.items[4]);
        this.rooms[7] = new Room("Dionysus' Wine Cellar", "A cellar filled withsbarrels of wine and walls covered by grapefines.");
        this.rooms[7].addObject(this.items[8]);
        this.rooms[7].addObject(this.items[0]);
        this.rooms[8] = new Room("Titan's Throne Room", "A grand hall housing the thrones for the powerful titains during the reign.");
        this.rooms[8].addObject(this.items[0]);
        this.rooms[9] = new Room("Thunderstorm Observatory", "A room dedicated to the Olympian God, panoramic windows, allowing the view of thunderstroms raging in the sky.");

        this.walls[0].AddDirection("West", this.walls[1]);
        this.walls[0].AddDirection("East", this.walls[3]);
        this.walls[0].AddDirection("North", this.rooms[0]);

        this.rooms[0].AddDirection("South", this.walls[0]);
        this.rooms[0].AddDirection("North", this.rooms[1]);
        this.rooms[1].AddDirection("North", this.rooms[2]);
        this.rooms[2].AddDirection("East", this.rooms[3]);
        this.rooms[3].AddDirection("East", this.rooms[4]);
        this.rooms[4].AddDirection("South", this.rooms[5]);
        this.rooms[5].AddDirection("East", this.rooms[6]);
        this.rooms[6].AddDirection("South", this.rooms[7]);
        this.rooms[7].AddDirection("West", this.rooms[8]);
        this.rooms[8].AddDirection("South", this.rooms[9]);

        this.adventurer = new Adventurer(this.rooms[0], null, 0);
    }

    startGame() {
        console.log('game starting!');
        this.intoGame();
        const fs = require('fs')
        const readline  = require('readline');
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        rl.on('line', (input) => {
            const command = input.trim();
            let currentLoc, newLoc = null;
            let takeItem;
            let b = false;

            currentLoc = this.adventurer.getLocation();
            this.showHelpMenu();

            if (command === "Go") {
                do {
                    console.log("Current Location: " + currentLoc);
                    console.log("Choose direction:");
                    console.log("North, South, East, West");
                    const direc = readline.question();
                    b = this.checkPathExist(direc, currentLoc);
                    if (b) {
                        newLoc = this.adventurerNextLocation(direc, currentLoc);
                        this.adventurer.setLocation(newLoc);
                    } else {
                        console.log("There is a Wall");
                        console.log("You can't Move to this direction");
                        console.log();
                    }
                } while (b === false);
            } else if (command === "Look") {
                if (currentLoc instanceof Room) {
                    currentLoc.viewRoomContent();
                }
                this.adventurer.viewInventory();
            } else if (command === "Take") {
                if (currentLoc instanceof Room) {
                    currentLoc.viewRoomContent();
                    console.log("Take the item 0/1/2/3 .. from the room: ");
                    takeItem = parseInt(readline.question());
                    const i = currentLoc.getRoomItem(takeItem);
                    this.adventurer.take(i);
                    this.adventurer.viewInventory();
                }
            } else if (command === "Drop") {
                this.adventurer.viewInventory();
                console.log("Drop the item 0/1/2/3 .. from the Inventory to room: ");
                takeItem = parseInt(readline.question());
                if (currentLoc instanceof Room) {
                    const i = this.adventurer.getInventoryItem(takeItem);
                    currentLoc.addObject(i);
                    currentLoc.viewRoomContent();
                }
            } else if (command === "Use") {
                this.adventurer.viewInventory();
                console.log("Use the item 0/1/2/3 .. from the Inventory: ");
                takeItem = parseInt(readline.question());
                const i = this.adventurer.getInventoryItem(takeItem);
                this.adventurer.drop(i);
            } else if (command === "Exit") {
                process.exit(0);
            } else {
                console.log("Invalid command");
            }
        });
    }

    showHelpMenu() {
        console.log("Choose command:");
        console.log("Go");
        console.log("Look");
        console.log("Take");
        console.log("Drop");
        console.log("Use");
        console.log("Exit");
        console.log();
    }

    checkPathExist(path, loc) {
        const hm = loc.getRoomDirection();
        if (hm.has(path)) {
            if (hm.get(path) instanceof Room) {
                return true;
            }
        }
        return false;
    }

    adventurerNextLocation(path, loc) {
        const hm = loc.getRoomDirection();
        if (hm.has(path)) {
            if (hm.get(path) instanceof Room) {
                return hm.get(path);
            }
        }
        return loc;
    }
}
