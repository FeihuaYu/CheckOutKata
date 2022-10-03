package src.main;

import java.util.Map;

public class TotalPrice {
    ItemsList itemsList;
    int totalPrices;
    PromotionItems promotionItems;

    public TotalPrice(ItemsList itemsList, PromotionItems promotionItems) {
        this.itemsList = itemsList;
        this.promotionItems = promotionItems;
        totalPrices = 0;
    }

    
    public int calculatePrice() {
        Map<String, Item> itemsMap = itemsList.getItemsMap();
        int promotionValue = 0;
        for(Item item : itemsMap.values()) {
            totalPrices += item.getPrice() * item.getQuantity();
            System.out.println("getQuantity is " + item.getQuantity());
            promotionValue = promotionItems.getPromotionMultiPrice().calculatePromotion(item);
            promotionValue += promotionItems.getPromotionOneFree().calculatePromotion(item);
        }

        // promotionValue = promotionItems.getPromotionMultiPrice().calculatePromotion();
        System.out.println("Promotion value is " + promotionValue);
        return totalPrices - promotionValue;
    }
}
