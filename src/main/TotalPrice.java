package src.main;

import java.util.Map;

public class TotalPrice {
    ItemsList itemsList;
    PromotionItems promotionItems;

    public TotalPrice(ItemsList itemsList, PromotionItems promotionItems) {
        this.itemsList = itemsList;
        this.promotionItems = promotionItems;
    }

    
    public int calculatePrice() {
        Map<String, Item> itemsMap = itemsList.getItemsMap();
        int promotionValue = 0;
        int totalPromotionValue = 0;
        int totalPrices = 0;

        if(itemsMap.isEmpty()){
            return totalPrices;
        }
        for(Item item : itemsMap.values()) {
            totalPrices += item.getPrice() * item.getQuantity();
            promotionValue = promotionItems.getPromotionMultiPrice().calculatePromotion(item);
            promotionValue += promotionItems.getPromotionOneFree().calculatePromotion(item);
            if(item.getID().equals(promotionItems.getPromotionMealDeal().getDealItemID1())){
                if(itemsMap.containsKey(promotionItems.getPromotionMealDeal().getDealItemID2())){
                    promotionValue += promotionItems.getPromotionMealDeal().calculatePromotion(item, itemsMap.get(promotionItems.getPromotionMealDeal().getDealItemID2()));
                }
            }
            totalPromotionValue = totalPromotionValue + promotionValue;
                    
        }

        return totalPrices - totalPromotionValue;
    }
}
