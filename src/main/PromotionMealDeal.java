package src.main;

import java.util.List;

public class PromotionMealDeal extends PromotionRules{
    private final int mealDealPrice = 300;
    private List<Item> mealDealList; 

    public PromotionMealDeal(List<Item> promotionItemList) {
        super(promotionItemList);
        mealDealList = promotionItemList;
    }
    

    // Buy D and E for £3
    @Override
    public int calculatePromotion(List<Integer> itemQuantityList) {
        int promotionValue = 0;
        int totalItemPrice = 0;

        int minItemQuantity = Integer.MAX_VALUE;

        for(Item item : mealDealList){
            int itemPrice = item.getPrice();
            totalItemPrice += itemPrice;
        }

        for(int itemQuantity : itemQuantityList){
            minItemQuantity = Math.min(minItemQuantity, itemQuantity);
        }

        promotionValue = (totalItemPrice - mealDealPrice) * minItemQuantity;

        return promotionValue;
    }


    public int getMealDealPrice() {
        return mealDealPrice;
    }



    public List<Item> getMealDealList() {
        return mealDealList;
    }

    @Override
    public int calculatePromotion(int itemQuantity) {
        // TODO Auto-generated method stub
        return 0;
    }

    
}
