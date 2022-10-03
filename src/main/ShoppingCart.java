package src.main;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> itemsMap;
    public ShoppingCart(){
        itemsMap = new HashMap<>();
    }
    
    public void add(Item item){
        int quantity = 1;
        if(itemsMap.containsKey(item)){
            quantity = itemsMap.get(item);
            itemsMap.put(item, ++quantity);
        }else{
            itemsMap.put(item, quantity);
        }

        
    }

    public Map<Item, Integer> getItemsMap() {
        return itemsMap;
    }

    
}

