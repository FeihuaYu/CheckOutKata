package src.main;

import java.util.Map;

public class TotalPrice {
    ItemsList itemsList;
    Item item;
    int totalPrices;

    public TotalPrice(ItemsList itemsList) {
        this.itemsList = itemsList;
    }

    
    public int calculatePrice() {
        Map<Item, Integer> itemsMap = itemsList.getItemsMap();
        int totalPrices = 0;
        for(Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            System.out.println("entry.getKey() is "+ entry.getKey().getID() + "  entry.getKey().getPrice() is " +  entry.getValue());
            totalPrices += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrices;
    }
}
