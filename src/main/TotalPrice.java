package src.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;



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

            totalPrices += itemQuantity * itemPrice;
        }

        Item targetMultiPriceItem = promotionItems.getPromotionMultiPrice().getMultiPriceItem();
        if(itemsMap.containsKey(targetMultiPriceItem)){
            promotionValue = promotionItems.getPromotionMultiPrice().calculatePromotion(itemsMap.get(targetMultiPriceItem));
            totalPromotionValue += promotionValue;
        }



        Item targetOneFreeItem = promotionItems.getPromotionOneFree().getOneFreeItem();
        if(itemsMap.containsKey(targetOneFreeItem)){
            promotionValue = promotionItems.getPromotionOneFree().calculatePromotion(itemsMap.get(targetOneFreeItem));
            totalPromotionValue += promotionValue;
        }



        List<Item> targetMealDealItem = promotionItems.getPromotionMealDeal().getMealDealList();
        List<Integer> quantityList = new LinkedList<>();
        for(Item item : targetMealDealItem){
            if(itemsMap.containsKey(item)){
                int quantity = itemsMap.get(item);
                quantityList.add(quantity);
            }
        }
        
        if(!quantityList.isEmpty() && quantityList.size()==targetMealDealItem.size()){
            promotionValue = promotionItems.getPromotionMealDeal().calculatePromotion(quantityList);
            totalPromotionValue += promotionValue;
        }

        return totalPrices - totalPromotionValue;
    }
}
