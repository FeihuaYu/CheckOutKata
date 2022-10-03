package src.main;

import java.util.List;

public class PromotionMultiPrice extends PromotionRules{
    private final int promotionQuantity;
    private int promotionPrice;

    public PromotionMultiPrice(Item promotionItem, int quantity, int discount) {
        super(promotionItem);
        promotionQuantity = quantity;
        promotionPrice = promotionItem.getPrice() * quantity - discount;
    }

    @Override
    public int calculatePromotion(List<Integer> itemQuantity) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public int calculatePromotion(int itemQuantity) {
        int promotionValue = 0;
        if(itemQuantity / promotionQuantity >= 1){
            int quotient = itemQuantity / promotionQuantity;  
            int reminder = itemQuantity % promotionQuantity;
            promotionValue = (itemQuantity * super.getPromotionItem().getPrice()) - 
                                    (quotient * promotionPrice + reminder * super.getPromotionItem().getPrice());
        }
        return promotionValue;

    }



}
