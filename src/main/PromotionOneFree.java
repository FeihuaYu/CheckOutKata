package src.main;

import java.util.List;

public class PromotionOneFree extends PromotionRules{

    public PromotionOneFree(Item promotionItem) {
        super(promotionItem);
        oneFreeItem = promotionItem;
    }


    private final int promotionQuantity = 3;
    private Item oneFreeItem;
    

    @Override
    // Buy 3, get one free 3/3=1 4/3=1 -1 5/3=1 -2 6/3=2
    public int calculatePromotion(int itemQuantity) {
        int promotionValue = 0;
        if(itemQuantity / promotionQuantity >= 1){
            int quotient = itemQuantity / promotionQuantity;
            promotionValue = oneFreeItem.getPrice() * quotient;
        }
       
        return promotionValue;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }


    @Override
    public int calculatePromotion(List<Integer> itemQuantity) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
