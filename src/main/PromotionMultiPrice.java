package src.main;

import java.util.List;

public class PromotionMultiPrice implements PromotionRules{

    private final int promotionPrice = 125;
    private final int promotionQuantity = 2;
    private Item multiPriceItem;
   
    public PromotionMultiPrice(Item multiPriceItem) {
        this.multiPriceItem = multiPriceItem;
    }

    public Item getMultiPriceItem() {
        return multiPriceItem;
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
            promotionValue = (itemQuantity * multiPriceItem.getPrice()) - 
                                    (quotient * promotionPrice + reminder * multiPriceItem.getPrice());
        }
        return promotionValue;

    }



}
