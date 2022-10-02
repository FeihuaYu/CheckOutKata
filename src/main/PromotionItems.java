package src.main;

public class PromotionItems {
    private Item item;

    private PromotionMultiPrice promotionMultiPrice;

    public PromotionItems(Item item, PromotionMultiPrice promotionMultiPrice) {
        this.item = item;
        this.promotionMultiPrice = promotionMultiPrice;
    }


    public Item getItem() {
        return item;
    }


    public PromotionMultiPrice getPromotionMultiPrice() {
        return promotionMultiPrice;
    }

    
}
