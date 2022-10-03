package src.main;

public class PromotionItems {
    private PromotionMultiPrice promotionMultiPrice;
    private PromotionOneFree promotionOneFree;
    private PromotionMealDeal promotionMealDeal;

    public PromotionItems(PromotionMultiPrice promotionMultiPrice, PromotionOneFree promotionOneFree, PromotionMealDeal promotionMealDeal) {
        this.promotionMultiPrice = promotionMultiPrice;
        this.promotionOneFree = promotionOneFree;
        this.promotionMealDeal = promotionMealDeal;
    }

    public PromotionMultiPrice getPromotionMultiPrice() {
        return promotionMultiPrice;
    }

    public PromotionOneFree getPromotionOneFree() {
        return promotionOneFree;
    }

    public PromotionMealDeal getPromotionMealDeal() {
        return promotionMealDeal;
    }

    
}
