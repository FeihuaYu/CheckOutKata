package src.main;

import java.util.List;

public class PromotionMultiPrice implements PromotionRules{

    private final String promotionItemID = "B";
    private final int promotionPrice = 125;
    private final int promotionQuantity = 2;
   
    public boolean isMultiPrice(String itemID){
        if(itemID.equals(promotionItemID)){
            return true;
        }
        return false;
    }

    @Override
    public int calculatePromotion(int itemQuantity, int itemPrice) {
        int promotionValue = 0;
        if(itemQuantity / promotionQuantity >= 1){
            int quotient = itemQuantity / promotionQuantity;  
            int reminder = itemQuantity % promotionQuantity;
            promotionValue = (itemQuantity * itemPrice) - 
                                    (quotient * promotionPrice + reminder * itemPrice);
        }
        return promotionValue;
    }


    @Override
    public int calculatePromotion(List<Integer> itemQuantity) {
        // TODO Auto-generated method stub
        return 0;
    }



}
