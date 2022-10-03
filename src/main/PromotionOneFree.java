package src.main;

public class PromotionOneFree implements PromotionRules{

    @Override
    // Buy 3, get one free 3/3=1 4/3=1 -1 5/3=1 -2 6/3=2
    public int calculatePromotion(Item item) {
        int promotionValue = 0;
        if(item.getID().equals("C")) {
            int quantity = item.getQuantity();
            if(quantity / 3 >= 1){
                int quotient = quantity / 3;
                promotionValue = item.getPrice() * quotient;
            }
        }
        return promotionValue;
    }
    
}
