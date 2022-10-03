package src.main;

import java.util.List;

public abstract class PromotionRules {
    private Item promotionItem;
    private List<Item> promotionItemList; 
    
    public List<Item> getPromotionItemList() {
        return promotionItemList;
    }


    public PromotionRules(List<Item> promotionItemList) {
        this.promotionItemList = promotionItemList;
    }


    public PromotionRules(Item promotionItem) {
        this.promotionItem = promotionItem;
    }


    public Item getPromotionItem() {
        return promotionItem;
    }


    public abstract int calculatePromotion(int itemQuantity);;
    public abstract int calculatePromotion(List<Integer> itemQuantity);
}
