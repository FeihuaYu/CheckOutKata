package src.main;

import java.util.HashMap;
import java.util.Map;

public class ItemsList {
    private Map<Item, Integer> itemsMap = new HashMap<>();

    
    public void add(Item item){
        int quantity = 1;
        if(itemsMap.containsKey(item)) {
            quantity = itemsMap.get(item);
            quantity++;
        }
        itemsMap.put(item, quantity);
        
    }


    public Map<Item, Integer> getItemsMap() {
        return itemsMap;
    }

    
    
}

