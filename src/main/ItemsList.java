package src.main;

import java.util.HashMap;
import java.util.Map;

public class ItemsList {
    // private Map<Item, Integer> itemsMap;
    private Map<String, Item> itemsMap;

    public ItemsList(){
        itemsMap = new HashMap<>();
    }
    
    public void add(Item item){
        int quantity = 1;
        if(itemsMap.containsKey(item.getID())) {
            quantity = item.getQuantity();
            item.setItemQuantity(++quantity);
            System.out.println("setItemQuantity is " + quantity);
        }else{
            item.setItemQuantity(quantity);
        }
        itemsMap.put(item.getID(), item);
        System.out.println("Item first setItemQuantity is " + item.getQuantity());
        
    }


    public Map<String, Item> getItemsMap() {
        return itemsMap;
    }

    
    
}

