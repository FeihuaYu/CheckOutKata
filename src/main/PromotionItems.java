package src.main;

public class PromotionItems {
    private Item item;
    private PromotionMultiPrice promotionMultiPrice;
    private PromotionOneFree promotionOneFree;

    public PromotionItems(PromotionMultiPrice promotionMultiPrice, PromotionOneFree promotionOneFree) {
        // this.item = item;
        this.promotionMultiPrice = promotionMultiPrice;
        this.promotionOneFree = promotionOneFree;
    }

    // public PromotionItems(Item item, PromotionOneFree promotionOneFree) {
    //     this.item = item;
    //     this.promotionOneFree = promotionOneFree;
    // }

    // public Item getItem() {
    //     return item;
    // }


    public PromotionMultiPrice getPromotionMultiPrice() {
        return promotionMultiPrice;
    }

    public PromotionOneFree getPromotionOneFree() {
        return promotionOneFree;
    }

    
}
