package src.main;

public class PromotionOneFree implements PromotionRules{

    private  String promotionItemID = "C";
    private  int promotionQuantity = 3;

    // public PromotionOneFree(String promotionItemID, int promotionQuantity) {
    //     this.promotionItemID = promotionItemID;
    //     this.promotionQuantity = promotionQuantity;
    // }

    @Override
    // Buy 3, get one free 3/3=1 4/3=1 -1 5/3=1 -2 6/3=2
    public int calculatePromotion(Item item) {
        int promotionValue = 0;
        if(item.getID().equals(promotionItemID)) {
            int quantity = item.getQuantity();
            if(quantity / promotionQuantity >= 1){
                int quotient = quantity / promotionQuantity;
                promotionValue = item.getPrice() * quotient;
            }
        }
        return promotionValue;
    }

    @Override
    public int calculatePromotion(Item item1, Item item2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
