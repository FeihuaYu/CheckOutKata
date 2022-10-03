package src.main;

public class PromotionMealDeal implements PromotionRules{
    private final String dealItemID1 = "D";
    private final String dealItemID2 = "E";
    private final int mealDealPrice = 300;

    @Override
    // Buy D and E for £3
    public int calculatePromotion(Item item1, Item item2) {
        int promotionValue = 0;
        if(item1.getID().equals(dealItemID1)){
            int quantity1 = item1.getQuantity();
            int quantity2 = item2.getQuantity();
            if(quantity1 == quantity2){
                promotionValue = (item1.getPrice() + item2.getPrice() - mealDealPrice) * quantity1;
            }else if(quantity1 > quantity2){
                promotionValue = (item1.getPrice() + item2.getPrice() - mealDealPrice) * quantity2;
            }else{
                promotionValue = (item1.getPrice() + item2.getPrice() - mealDealPrice) * quantity1;
            }
        }

        return promotionValue;
    }

    public String getDealItemID2() {
        return dealItemID2;
    }

    @Override
    public int calculatePromotion(Item item) {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getDealItemID1() {
        return dealItemID1;
    }

    public int getMealDealPrice() {
        return mealDealPrice;
    }

    
}
