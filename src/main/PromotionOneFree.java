package src.main;

import java.util.List;

public class PromotionOneFree implements PromotionRules{

    private final String promotionItemID = "C";
    private final int promotionQuantity = 3;

    public boolean isOneFree(String itemID){
        if(itemID.equals(promotionItemID)){
            return true;
        }    
        return false;
        
    }

    @Override
    // Buy 3, get one free 3/3=1 4/3=1 -1 5/3=1 -2 6/3=2
    public int calculatePromotion(int itemQuantity, int itemPrice) {
        int promotionValue = 0;
        if(itemQuantity / promotionQuantity >= 1){
            int quotient = itemQuantity / promotionQuantity;
            promotionValue = itemPrice * quotient;
        }
       
        return promotionValue;
    }

    public String getPromotionItemID() {
        return promotionItemID;
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
