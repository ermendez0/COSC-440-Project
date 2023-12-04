class Item {
    constructor(name, desc) {
        this.name = name;
        this.desc = desc;
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

    look() {
        return this.getDesc();
    }

    toString() {
        return "Item name=" + this.name + ", desc=" + this.desc;
    }
}

