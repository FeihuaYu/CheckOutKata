package src.main;

import java.util.LinkedList;
import java.util.List;

public class PromotionMealDeal implements PromotionRules{
    private final int mealDealPrice = 300;
    private List<Item> mealDealList; 

    
    public PromotionMealDeal(List<Item> mealDealList) {
        this.mealDealList = mealDealList;
    }

    @Override
    // Buy D and E for £3
    public int calculatePromotion(List<Integer> itemQuantity) {
        int promotionValue = 0;
        
        int itemPrice1 = mealDealList.get(0).getPrice();
        int itemPrice2 = mealDealList.get(1).getPrice();
        int itemQuantity1 = itemQuantity.get(0);
        int itemQuantity2 = itemQuantity.get(1);

        promotionValue = (itemPrice1 + itemPrice2 - mealDealPrice) * Math.min(itemQuantity1, itemQuantity2);

        return promotionValue;
    }


    public int getMealDealPrice() {
        return mealDealPrice;
    }

    @Override
    public int calculatePromotion(int itemQuantity, int itemPrice) {
        // TODO Auto-generated method stub
        return 0;
    }

    public List<Item> getMealDealList() {
        return mealDealList;
    }

    
}
