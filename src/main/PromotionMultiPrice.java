package src.main;

public class PromotionMultiPrice implements PromotionRules{
    Item item;

    // public PromotionMultiPrice(Item item) {
    //     this.item = item;
    // }

    @Override
    // 2 for 125, 75 ,125+75=200, 3*75=225 3/2=1 1*125
    public int calculatePromotion(Item item) {
        int promotionValue = 0;
        if(item.getID().equals("B")){
            System.out.println("item.getID() is " + item.getID() + " calculatePromotion inside");
            int quantity = item.getQuantity();
            if(quantity / 2 >= 1){
                int quotient = quantity / 2;  
                int reminder = quantity % 2;
                promotionValue = (quantity * item.getPrice()) - 
                                        (quotient * 125 + reminder * item.getPrice());
            }
        }

        return promotionValue;
    }



}
