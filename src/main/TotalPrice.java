package src.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

public class TotalPrice {
    ShoppingCart itemsList;
    PromotionItems promotionItems;

    public TotalPrice(ShoppingCart itemsList, PromotionItems promotionItems) {
        this.itemsList = itemsList;
        this.promotionItems = promotionItems;
    }

    
    public int calculatePrice() {
        Map<Item, Integer> itemsMap = itemsList.getItemsMap();
        int promotionValue = 0;
        int totalPromotionValue = 0;
        int totalPrices = 0;

        if(itemsMap.isEmpty()){
            return totalPrices;
        }

        for(Map.Entry<Item, Integer> entry: itemsMap.entrySet()){
            int itemQuantity = entry.getValue();
            int itemPrice = entry.getKey().getPrice();
            String itemID = entry.getKey().getID();
            totalPrices += itemQuantity * itemPrice;

            System.out.println("init totalPromotionValue is " + totalPromotionValue);
            if(promotionItems.getPromotionOneFree().isOneFree(itemID)){
                promotionValue = promotionItems.getPromotionOneFree().calculatePromotion(itemQuantity, itemPrice);
                totalPromotionValue += promotionValue;
            }
            System.out.println("first totalPromotionValue is " + totalPromotionValue);
            if(promotionItems.getPromotionMultiPrice().isMultiPrice(itemID)){
                promotionValue = promotionItems.getPromotionMultiPrice().calculatePromotion(itemQuantity, itemPrice);
                totalPromotionValue += promotionValue;
            }
            System.out.println("second totalPromotionValue is " + totalPromotionValue);
            
            System.out.println("itemQuantity is " + itemQuantity);
            System.out.println("itemPrice is " + itemPrice);
            System.out.println("totalPromotionValue is " + totalPromotionValue);
        }

        List<Item> targetItem = promotionItems.getPromotionMealDeal().getMealDealList();
        List<Integer> quantityList = new LinkedList<>();
        for(Item item : targetItem){
            if(itemsMap.containsKey(item)){
                int quantity = itemsMap.get(item);
                quantityList.add(quantity);
            }
        }
        
        if(!quantityList.isEmpty() && quantityList.size()==targetItem.size()){
            promotionValue = promotionItems.getPromotionMealDeal().calculatePromotion(quantityList);
            totalPromotionValue += promotionValue;
        }

        return totalPrices - totalPromotionValue;
    }
}
