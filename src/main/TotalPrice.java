package src.main;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class TotalPrice {
    private PromotionItems promotionItems;
    private Map<Item, Integer> itemsMap;

    public TotalPrice(ShoppingCart itemsList, PromotionItems promotionItems) {
        this.promotionItems = promotionItems;
        itemsMap = itemsList.getItemsMap();
    }

    
    public int calculatePrice() {
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

        totalPromotionValue = calculatePromotionValue(promotionItems.getPromotionOneFree()) + calculatePromotionValue(promotionItems.getPromotionMultiPrice())
                            + calculatePromotionMealDeal(promotionItems.getPromotionMealDeal());
        return totalPrices - totalPromotionValue;
    }


    public int calculatePromotionValue(PromotionRules promotionRules){
        int promotionValue = 0;
        Item targetOneFreeItem = promotionRules.getPromotionItem();
        if(itemsMap.containsKey(targetOneFreeItem)){
            promotionValue = promotionRules.calculatePromotion(itemsMap.get(targetOneFreeItem));
        }
        return promotionValue;
    }


    public int calculatePromotionMealDeal(PromotionRules promotionRules){
        int promotionValue = 0;
        List<Item> targetMealDealItem = promotionRules.getPromotionItemList();
        List<Integer> quantityList = new LinkedList<>();
        for(Item item : targetMealDealItem){
            if(itemsMap.containsKey(item)){
                int quantity = itemsMap.get(item);
                quantityList.add(quantity);
            }
        }
        if(!quantityList.isEmpty() && quantityList.size()==targetMealDealItem.size()){
            promotionValue = promotionItems.getPromotionMealDeal().calculatePromotion(quantityList);
        }
        return promotionValue;
    }
}
