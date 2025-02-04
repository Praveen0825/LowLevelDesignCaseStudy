package Factory;

import Entity.*;

public class ItemFactory {
    public static Item createItem(String name) {
        switch (name.toLowerCase()) {
            case "chips": return new Chips();
            case "soda": return new Soda();
            case "chocolate": return new Chocolate();
            default: throw new IllegalArgumentException("Unknown item: " + name);
        }
    }
}
