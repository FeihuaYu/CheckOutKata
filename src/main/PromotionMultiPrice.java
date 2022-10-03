package src.main;

public class PromotionMultiPrice implements PromotionRules{

    private final String promotionItemID = "B";
    private final int promotionPrice = 125;
    private final int promotionQuantity = 2;
    @Override
    // 2 for 125, 75 ,125+75=200, 3*75=225 3/2=1 1*125
    public int calculatePromotion(Item item) {
        int promotionValue = 0;
        if(item.getID().equals(promotionItemID)){
            int quantity = item.getQuantity();
            if(quantity / promotionQuantity >= 1){
                int quotient = quantity / promotionQuantity;  
                int reminder = quantity % promotionQuantity;
                promotionValue = (quantity * item.getPrice()) - 
                                        (quotient * promotionPrice + reminder * item.getPrice());
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
